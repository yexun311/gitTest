package com.ye.cache;

import com.dssp.common.util.MonitorUtils;
import com.dssp.model.bo.qianqu1.QQMacroReplace;
import com.dssp.model.bo.qianqu1.req.*;
import com.dssp.model.bo.qianqu1.resp.QQAdsResponse;
import com.dssp.model.bo.qianqu1.resp.QQMetaGroupResp;
import com.dssp.model.bo.qianqu1.resp.QQResponse;
import com.dssp.model.bo.qianqu1.resp.QQTrackResponse;
import com.dssp.model.es.request.channel.AdRequestQianQuEs;
import com.dssp.model.es.response.channel.AdResponseQianQuEs;
import com.dssp.service.admian.common.CommonService;
import com.dssp.strategy.admian.AbsChannelStrategy;
import com.ssp.common.constants.NumConstants;
import com.ssp.common.dto.AdReqExpandDto;
import com.ssp.common.dto.MonitorContextDto;
import com.ssp.common.enums.system.HttpStatusEnum;
import com.ssp.common.enums.system.ResultEnum;
import com.ssp.common.model.es.AdRequestChannelEs;
import com.ssp.common.model.es.AdResponseChannelEs;
import com.ssp.common.model.ssp.ResultData;
import com.ssp.common.model.ssp.req.*;
import com.ssp.common.model.ssp.resp.SspAdvResponse;
import com.ssp.common.model.ssp.resp.SspDataResponse;
import com.ssp.common.model.ssp.resp.SspMonitorResponse;
import com.ssp.common.model.ssp.resp.SspVideoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 千曲
 * @author yxd
 * @since 2022/8/17 13:42
 */
@Component("qianquService")
@Slf4j
public class QianQuServiceImpl extends AbsChannelStrategy<QQRequest, QQResponse>{

    @Value("${adhost.qianquUrl}")
    private String qqUrl;

    @Value("${notifyHostUrl}")
    private String notifyHostUrl;

    @Resource
    private CommonService commonService;

    @Override
    public String getUrl(AdReqExpandDto expandDto) {
        return qqUrl + "?ad_code=" + expandDto.getOppositeAdsId();
    }

    @Override
    public Class<? extends AdRequestChannelEs> getAdRequestEsClass() {
        return AdRequestQianQuEs.class;
    }

    @Override
    public Class<? extends AdResponseChannelEs> getAdResponseEsClass() {
        return AdResponseQianQuEs.class;
    }

    @Override
    public QQRequest convertRequest(SspReqModel sspReqModel, AdReqExpandDto expandDto) {
        SspDataRequest dataRequest = sspReqModel.getSspDataRequest();
        SspDeviceRequest deviceRequest = dataRequest.getDevice();
        SspAppRequest appRequest = dataRequest.getApp();
        SspUserRequest userRequest = dataRequest.getUser();

        QQRequest request = new QQRequest();

        request.setRequestId(sspReqModel.getRequestId());
        //request.setChannelId();
        //request.setSecure();

        /* device */
        if(!Objects.isNull(deviceRequest)){
            QQDeviceRequest device = new QQDeviceRequest();

            device.setIdfa(deviceRequest.getDeviceId());
            device.setImei(deviceRequest.getImei());
            device.setMac(deviceRequest.getMac());
            device.setAndroidId(deviceRequest.getDeviceId());
            device.setOaid(deviceRequest.getOaid());
            device.setModel(deviceRequest.getModel());
            device.setVendor(deviceRequest.getBrand());
            device.setScreenHeight(deviceRequest.getSheight());
            device.setScreenWidth(deviceRequest.getSwidth());
            device.setOsType(osConverter(deviceRequest.getOs()));
            device.setOsVersion(deviceRequest.getOsVersion());
            device.setUa(dataRequest.getUa());
            device.setPpi(Optional.ofNullable(deviceRequest.getDpi()).map(Double::intValue).orElse(0));
            device.setScreenOrientation(deviceRequest.getOrientation());
            device.setBrand(deviceRequest.getBrand());
            device.setImsi(deviceRequest.getImsi());

            request.setDevice(device);

        }

        /* network */
        QQNetworkRequest network = new QQNetworkRequest();

        network.setIp(dataRequest.getIp());
        //network.setIp6();
        if(!Objects.isNull(deviceRequest)){
            network.setConnectionType(networkConverter(deviceRequest.getNetwork()));
            //network.setCellular_id();
            network.setOperatorType(deviceRequest.getOperatorType());
        }
        if(!Objects.isNull(appRequest) && appRequest.getLatitude()!=null && appRequest.getLatitude()!=null){
            network.setLat(Optional.ofNullable(appRequest.getLatitude()).map(Double::floatValue).orElse(0f));
            network.setLon(Optional.ofNullable(appRequest.getLongitude()).map(Double::floatValue).orElse(0f));
        }
        //network.setMcc();
        //network.setMnc();

        request.setNetwork(network);

        /* user */
        if(!Objects.isNull(userRequest)){
            QQUserRequest user = new QQUserRequest();

            user.setGender(genderConverter(userRequest.getGender()));
            user.setAge(userRequest.getAge());
            user.setHobby(userRequest.getHobby());

            request.setUser(user);
        }

        /* ext */
        request.setExt(new QQExtRequest(dataRequest.getDeepLink() ? 1:0));

        return request;
    }

    /**
     * 操作系统转换
     * @param os Android + IOS
     * @return 操作系统类型。1-Android 2-IOS
     */
    public Integer osConverter(String os){
        if(os.equalsIgnoreCase("Android"))
            return 1;
        if(os.equalsIgnoreCase("IOS"))
            return 2;
        return null;
    }

    /**
     * 网络类型转换
     * @param network 设备的网络类型
     *  Unknown=0;Wifi=1;2G=2;3G=3;4G=4;5G=5
     * @return 连接网路类型
     *  0--CONNECTION_UNKNOW
     *  1--CELL_UNKNOWN
     *  2--CELL_2G
     *  3--CELL_3G
     *  4--CELL_4G
     *  5--CELL_5G
     *  100—WIFI
     *  101—ETHERNET
     *  999--NEW_TYPE
     */
    public Integer networkConverter(Integer network){
        if (network == 2 || network == 3 || network == 4 || network == 5)
            return network;
        if(network == 1)
            return 100;
        return 0;
    }

    /**
     * 性别对应
     * @param gender 用户性别:Unknown=0; Male=1;Female=2
     * @return 性别。0-女，1-男，2-未知
     */
    public Integer genderConverter(Integer gender){
        if (gender == 1)
            return 1;
        if(gender == 2)
            return 0;
        return 2;
    }

    @Override
    public ResultData<SspDataResponse> convertResponse(QQResponse qqResponse, SspReqModel sspReqModel, AdReqExpandDto expandDto) {
        SspDataResponse sspDataResponse = new SspDataResponse(HttpStatusEnum.FAIL, sspReqModel.getRequestId());
        if (Objects.isNull(qqResponse)) {
            return new ResultData(ResultEnum.R_CODE20021, "", sspDataResponse);
        }
        if(!NumConstants.ZERO.equals(qqResponse.getErrorCode())){
            log.info("QianQuServiceImpl.gainAds:渠道返回错误码信息：errorCode{}",qqResponse.getErrorCode());
            return new ResultData(ResultEnum.R_CODE20022, qqResponse.getErrorCode(), sspDataResponse);
        }

        QQAdsResponse qqAds = qqResponse.getAds().get(0);
        if (Objects.isNull(qqAds))
            return new ResultData(ResultEnum.R_CODE20021, "", sspDataResponse);
        QQMetaGroupResp qqMetaGroup = qqAds.getMetaGroup().get(0);


        SspAdvResponse adv = new SspAdvResponse();

        adv.setSlotId(sspReqModel.getMediaAdId());
        if(!Objects.isNull(qqMetaGroup)){
            adv.setImgUrls(qqMetaGroup.getImageUrl());
            adv.setClickAdUrl(qqMetaGroup.getClickUrl());
            adv.setCreativeType(qqMetaGroup.getCreativeType()>=1 && qqMetaGroup.getCreativeType()<=4 ? qqMetaGroup.getCreativeType():null);
            adv.setTitle(qqMetaGroup.getAdTitle());
            adv.setDescriptions(qqMetaGroup.getDescs().get(0));
            adv.setDeeplink(qqMetaGroup.getDeepLink());
            //adv.setSource();
            //adv.setAppName();
            adv.setPackageName(qqMetaGroup.getPackageName());
            adv.setDownloadUrl(qqMetaGroup.getDownloadLink());
            adv.setIconSrcs(qqMetaGroup.getIconUrls().get(0));
        }
        adv.setReportAddHeaderUa(true);
        adv.setReportCoordinatesInterger(true);

        /* video */
        if(!Objects.isNull(qqMetaGroup)){
            SspVideoResponse video = new SspVideoResponse();

            video.setSrc(qqMetaGroup.getVideoUrl());
            video.setVideoDuration(qqMetaGroup.getVideoDuration());
            video.setSize(qqMetaGroup.getVideoSize());
            video.setVideoWidth((qqMetaGroup.getVideoWidth()));
            video.setVideoHeight(qqMetaGroup.getVideoHeight()*1000);
            //video.setCoverImgUrl();
            //video.setButtonText();
            //video.setEndImgUrl();
            //video.setEndHtml();
            video.setAutoLanding(false);
            video.setPrefetch(false);
            video.setClickAble(false);
            video.setSkipSeconds(0);

            adv.setVideo(video);
        }


        List<SspMonitorResponse> monitors = new ArrayList<>();
        MonitorContextDto monitorContext = MonitorUtils.monitorContext(sspReqModel, expandDto);
        List<QQMetaGroupResp> metaGroups = qqAds.getMetaGroup();
        if (metaGroups != null) {
            MonitorUtils.analysisAnnotation(notifyHostUrl, monitors, monitorContext, metaGroups, QQMacroReplace.getValues());
        }

        List<QQTrackResponse> tracks = qqAds.getTracks();
        if(tracks != null){
            MonitorUtils.analysisNotAnnotation(notifyHostUrl, monitors, monitorContext, tracks, QQTrackResponse.class);
        }

        adv.setMonitors(monitors);
        sspDataResponse.setAdv(adv);
        sspDataResponse.setCode(HttpStatusEnum.OK.getCode());
        sspDataResponse.setMsg(HttpStatusEnum.OK.getText());
        return new ResultData<>(sspDataResponse);

    }

}
