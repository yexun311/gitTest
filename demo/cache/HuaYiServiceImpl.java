package com.ye.cache;

import com.dssp.common.util.MonitorUtils;
import com.dssp.model.bo.huayi.HYMacroReplace;
import com.dssp.model.bo.huayi.req.*;
import com.dssp.model.bo.huayi.resp.HYAdResponse;
import com.dssp.model.bo.huayi.resp.HYAdTrackingResp;
import com.dssp.model.bo.huayi.resp.HYResponse;
import com.dssp.model.bo.huayi.resp.HYVideoTrackerResp;
import com.dssp.model.es.request.channel.AdRequestHuaYiEs;
import com.dssp.model.es.response.channel.AdResponseHuaYiEs;
import com.dssp.service.admian.common.CommonService;
import com.dssp.strategy.admian.AbsChannelStrategy;
import com.google.common.collect.Lists;
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
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 华毅亮点-华毅
 * @author yxd
 * @since 2022/8/17 17:13
 */
@Component("huayiService")
@Slf4j
public class HuaYiServiceImpl extends AbsChannelStrategy<HYRequest, HYResponse>{

    @Value("${adhost.huayiUrl}")
    private String hyUrl;

    @Value("${notifyHostUrl}")
    private String notifyHostUrl;

    @Resource
    private CommonService commonService;

    @Override
    public String getUrl(AdReqExpandDto expandDto) {
        return hyUrl + "?ad_code=" + expandDto.getOppositeAdsId();
    }

    @Override
    public Class<? extends AdRequestChannelEs> getAdRequestEsClass() {
        return AdRequestHuaYiEs.class;
    }

    @Override
    public Class<? extends AdResponseChannelEs> getAdResponseEsClass() {
        return AdResponseHuaYiEs.class;
    }

    @Override
    public HYRequest convertRequest(SspReqModel sspReqModel, AdReqExpandDto expandDto) {
        SspDataRequest dataRequest = sspReqModel.getSspDataRequest();
        SspAdslotRequest adslotRequest = dataRequest.getAdslot();
        SspDeviceRequest deviceRequest = dataRequest.getDevice();
        SspAppRequest appRequest = dataRequest.getApp();

        HYRequest request = new HYRequest();

        request.setRequest_id(sspReqModel.getRequestId());

        /* adslot */
        if(!Objects.isNull(adslotRequest)){
            HYAdslotRequest adslot = new HYAdslotRequest();

            adslot.setAdslot_id(adslotRequest.getSlotId());
            HYAdslotSizeRequest adslotSize = new HYAdslotSizeRequest();
            adslotSize.setWidth(adslotRequest.getWidth());
            adslotSize.setHeight(adslotRequest.getHeight());
            adslot.setAdslot_size(adslotSize);

            request.setAdslot(adslot);
        }

        /* apiVersion */
        /* HYApiVersionRequest apiVersion = new HYApiVersionRequest();

        apiVersion.setMajor();
        apiVersion.setMinor();
        apiVersion.setMicro();

        request.setApi_version(apiVersion); */

        /* app */
        HYAppRequest app = new HYAppRequest();

        app.setApp_id(expandDto.getOppositeAppId());
        app.setApp_package(expandDto.getChannelAppPackage());
        /* appVersion */
        /* HYAppVersionRequest appVersion = new HYAppVersionRequest();
        appVersion.setMajor();
        appVersion.setMinor();
        appVersion.setMicro();
        app.setApp_version(appVersion); */

        request.setApp(app);

        /* device */
        if(!Objects.isNull(deviceRequest)){
            HYDeviceRequest device = new HYDeviceRequest();

            device.setDevice_type(deviceRequest.getDeviceType());
            device.setOs_type(osConverter(expandDto.getOs()));
            /* OsVersion */
            /* HYOsVersionRequest osVersion = new HYOsVersionRequest();
            osVersion.setMajor();
            osVersion.setMinor();
            osVersion.setMicro();
            device.setOs_version(osVersion); */
            device.setVendor(deviceRequest.getBrand());
            device.setBrand(deviceRequest.getBrand());
            device.setModel(deviceRequest.getModel());

            /* screenSize */
            HYScreenSizeRequest screenSize = new HYScreenSizeRequest();
            screenSize.setWidth(deviceRequest.getSwidth());
            screenSize.setHeight(deviceRequest.getSheight());
            device.setScreen_size(screenSize);

            device.setUser_agent(dataRequest.getUa());
            device.setOrientation(deviceRequest.getOrientation()==2 ? 1:2);

            /* udid */
            HYUdidRequest udid = new HYUdidRequest();
            udid.setImei(deviceRequest.getImei());
            udid.setOaid(deviceRequest.getOaid());
            udid.setImsi(deviceRequest.getImsi());
            udid.setAndroid_id(deviceRequest.getDeviceId());
            udid.setMac(deviceRequest.getMac());
            udid.setIdfa(deviceRequest.getDeviceId());
            //udid.setIdfv();
            udid.setOpenudid(deviceRequest.getOpenUdid());
            udid.setSerial_number(deviceRequest.getDeviceId());
            //udid.setAaid();
            //udid.setIdfa_md5();
            udid.setImei_md5(deviceRequest.getImeiMd5());
            //udid.setImei_sha1();
            //udid.setAndroidid_md5();
            //udid.setAndroidid_sha1();
            //udid.setMac_md5();
            udid.setCaid(deviceRequest.getCaid());
            device.setUdid(udid);

            device.setPpi(Optional.ofNullable(deviceRequest.getDpi()).map(Double::intValue).orElse(0));
            device.setDensity(deviceRequest.getDpi());
            device.setRom_version(deviceRequest.getRomVersion());
            device.setSys_compiling_time(Long.valueOf(deviceRequest.getSysComplingTime()));
            //device.setReferer();
            device.setCountry("CN");
            device.setLanguage(deviceRequest.getLanguage());
            device.setTimezone(deviceRequest.getTimeZone());
            device.setStartup_time(deviceRequest.getBootTimeSec() != null ? String.valueOf(deviceRequest.getBootTimeSec()) : null);
            device.setPhone_name(deviceRequest.getPhoneName());
            device.setMem_total(Optional.ofNullable(deviceRequest.getMemorySize()).map(Integer::longValue).orElse(0L)*1000*1000*1000);
            device.setDisk_total(Optional.ofNullable(deviceRequest.getDiskSize()).map(Integer::longValue).orElse(0L)*1000*1000*1000);
            device.setMb_time(String.valueOf(deviceRequest.getOsUpdateTimeSec()));
            device.setMode_code(deviceRequest.getModelCode());
            device.setAuth_status(deviceRequest.getLmt());
            device.setCpu_num(deviceRequest.getCpuNum());
            device.setCpu_frequency(Optional.ofNullable(deviceRequest.getCpuFrequency()).map(Float::doubleValue).orElse(0D));
            device.setBattery_status(batteryStatusConverer(deviceRequest.getBatteryStatus()));
            device.setBattery_power(deviceRequest.getBatteryPower());
            //device.setHwv();
            //device.setApi_level();
            device.setStorever(deviceRequest.getAppStoreVersion());
            device.setHmsver(deviceRequest.getHmsVersion());

            request.setDevice(device);
        }

        /* network */
        HYNetworkRequest network = new HYNetworkRequest();
        network.setIpv4(dataRequest.getIp());
        //network.setIpv6();
        if(deviceRequest.getNetwork() != null)
            network.setConnection_type(networkConverter(deviceRequest.getNetwork()));
        network.setOperator_type(deviceRequest.getOperatorType());
        //network.setCellular_id();
        //network.setMcc();
        //network.setMnc();
        request.setNetwork(network);

        /* gps */
        HYGpsRequest gps = new HYGpsRequest();
        if(appRequest.getLatitude() != null)
            gps.setLatitude(appRequest.getLatitude());
        if(appRequest.getLongitude() != null)
            gps.setLongitude(appRequest.getLongitude());
        gps.setCoordinate_type(1);
        gps.setTimestamp(System.currentTimeMillis());
        gps.setAccu(deviceRequest.getLaccu() != null ? deviceRequest.getLaccu() : null);
        request.setGps(gps);

        /* wifi */
        HYWifiRequest wifi = new HYWifiRequest();
        wifi.setAp_mac(deviceRequest.getWifiMac());
        wifi.setAp_name(deviceRequest.getSsid());
        //wifi.setIs_connected();
        //wifi.setRssi();
        request.setWifi(wifi);

        request.setRequest_protocol_type(1);
        request.setSupport_deeplink(dataRequest.getDeepLink());

        /* web */
        HYWebRequest web = new HYWebRequest();
        //web.setUrl();
        web.setTitle(adslotRequest.getTitle() != null ? adslotRequest.getTitle() : null);
        //web.setSource_url();
        //web.setKeywords();
        //web.setDomain();
        request.setWeb(web);

        return request;
    }

    /**
     * 操作系统转换
     * @param os 渠道 操作系统类型 1 ios 2 android 3 其他
     * @return 1：ANDROID 2：IOS
     */
    public Integer osConverter(Integer os){
        if(os == 1)
            return 2;
        if(os == 2)
            return 1;
        return null;
    }

    /**
     * 电池充电状态转换
     * @param batteryStatus 池充电状态，IOS操作系统必传0未知1不充电2充电3满电
     * @return 电池充电状态，IOS系统必填
     *  Unkow：未知
     *  Unplugged：不充电
     *  Charging：充电
     *  Full：满电
     */
    public String batteryStatusConverer(Integer batteryStatus){
        switch(batteryStatus){
            case 1:
                return "Unplugged";
            case 2:
                return "Charging";
            case 3:
                return "Full";
            default:
                return "Unknow";
        }
    }

    /**
     * 网络类型转换
     * @param network 设备的网络类型:Unknown=0;Wifi=1;2G=2;3G=3;4G=4;5G=5
     * @return 网络类型
     *  0 无法探测网络状态;
     *  1 蜂窝数据接入;
     *  2：2G网络;
     *  3： 3G网络;
     *  4： 4G网;
     *  5： 5G网络;
     *  100：Wi-Fi网络
     *  101：以太网接入;
     *  999：未知新类型
     */
    public Integer networkConverter(Integer network){
        if(network >= 2 && network<=5)
            return network;
        if(network == 1)
            return 100;
        return 0;
    }

    @Override
    public ResultData<SspDataResponse> convertResponse(HYResponse hyResponse, SspReqModel sspReqModel, AdReqExpandDto expandDto) {
        SspDataResponse sspDataResponse = new SspDataResponse(HttpStatusEnum.FAIL, sspReqModel.getRequestId());
        if (Objects.isNull(hyResponse)) {
            return new ResultData(ResultEnum.R_CODE20021, "", sspDataResponse);
        }
        if(!NumConstants.ZERO.equals(hyResponse.getError_code())){
            log.info("HuaYiLiangDianServiceImpl.gainAds:渠道返回错误码信息：errorCode{}",hyResponse.getError_code());
            return new ResultData(ResultEnum.R_CODE20022, hyResponse.getError_code().toString(), sspDataResponse);
        }

        HYAdResponse hyAd = hyResponse.getAds().get(0);
        if (Objects.isNull(hyAd))
            return new ResultData(ResultEnum.R_CODE20021, "", sspDataResponse);

        SspAdvResponse adv = new SspAdvResponse();

        adv.setSlotId(sspReqModel.getMediaAdId());
        adv.setImgUrls(hyAd.getImage_src());
        adv.setClickAdUrl(hyAd.getLink_url());
        adv.setCreativeType(hyAd.getCreative_type());
        adv.setInteractionType(interactionTypeConverter(hyAd.getInteraction_type()));
        adv.setTitle(hyAd.getAd_title());
        adv.setDescriptions(hyAd.getDescription());
        adv.setDeeplink(hyAd.getDeeplink_url());
        adv.setAppName(hyAd.getBrand_name());
        adv.setPackageName(hyAd.getApp_package());
        adv.setIconSrcs(hyAd.getIcon_src().get(0));
        adv.setReportAddHeaderUa(true);

        adv.setReportCoordinatesInterger(true);
        if (!CollectionUtils.isEmpty(hyAd.getImage_src())) {
            adv.setSource(hyAd.getImage_src().get(0));
        }
        if (NumConstants.ONE.equals(hyAd.getFallback_type())) {
            adv.setDownloadUrl(hyAd.getDeeplink_url());
        }

        /* video */
        SspVideoResponse video = new SspVideoResponse();
        video.setSrc(hyAd.getVideo_url());
        video.setVideoDuration(hyAd.getVideo_duration());
        //video.setSize();
        //video.setVideoWidth();
        //video.setVideoHeight();
        if(hyAd.getCard() != null){
            video.setCoverImgUrl(Lists.newArrayList(hyAd.getCard().getPreimgurl()));
            video.setButtonText(hyAd.getCard().getEndbutton());
            video.setEndImgUrl(Lists.newArrayList(hyAd.getCard().getEndimgurl()));
            video.setEndHtml(hyAd.getCard().getEndcardhtml());
        }
        video.setAutoLanding(false);
        video.setPrefetch(false);
        video.setClickAble(false);
        video.setSkipSeconds(0);
        adv.setVideo(video);

        List<SspMonitorResponse> monitors = new ArrayList<>();
        MonitorContextDto monitorContext = MonitorUtils.monitorContext(sspReqModel, expandDto);

        HYAdTrackingResp adTracking = hyAd.getAd_tracking();
        if (adTracking != null) {
            MonitorUtils.analysisAnnotation(notifyHostUrl, monitors, monitorContext, adTracking, HYMacroReplace.getValues());
        }
        HYVideoTrackerResp videoTracker = hyAd.getAd_tracking().getVideo_tracker().get(0);
        if (videoTracker != null) {
            MonitorUtils.analysisAnnotation(notifyHostUrl, monitors, monitorContext, videoTracker, HYMacroReplace.getValues());
        }
        adv.setMonitors(monitors);
        sspDataResponse.setAdv(adv);
        sspDataResponse.setCode(HttpStatusEnum.OK.getCode());
        sspDataResponse.setMsg(HttpStatusEnum.OK.getText());
        return new ResultData<>(sspDataResponse);

    }

    /**
     * 广告交互类型转换
     * @param interactionType 交互类型：
     *  0 无动作，即广告广告点击后无需进行任何响应
     *  1 使用浏览器打开网页
     *  2 下载应用
     *  3 deeplink唤醒
     * @return 广告的交互类型，使用浏览器打开（跳转）=1;应用内打开=2;直接下载应用=3，访问后下载=4
     */
    public Integer interactionTypeConverter(Integer interactionType){
        if(interactionType == 1)
            return 1;
        if(interactionType == 2)
            return 3;
        if(interactionType == 3)
            return 4;
        return null;
    }

}
