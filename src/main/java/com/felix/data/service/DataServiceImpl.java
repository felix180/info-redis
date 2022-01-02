package com.felix.data.service;

import com.felix.data.domain.DataRequest;
import com.felix.data.repository.ModelRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DataServiceImpl implements DataService {

  public static final String BIAS = "bias";
  public static final Double COEFFICIENT = -3935.364339858757;
  @Autowired private ModelRedisRepository redisRepository;

  @Override
  public Double processData(DataRequest dataRequest) {

    return getValueCTR(dataRequest);
  }

  private Double getValueCTR(DataRequest dataRequest) {
    String deviceExtBrowser = "deviceExtBrowser=" + dataRequest.getDeviceExtBrowser();
    String bannerExtSize = "bannerExtSize=" + dataRequest.getBannerExtSize();
    String deviceLanguage = "deviceLanguage=" + dataRequest.getDeviceLanguage();
    String deviceExtType = "deviceExtType=" + dataRequest.getDeviceExtType();

    Double sum =
        redisRepository.findModelByKey(deviceExtBrowser)
            + redisRepository.findModelByKey(deviceExtType)
            + redisRepository.findModelByKey(deviceLanguage)
            + redisRepository.findModelByKey(bannerExtSize)
            + redisRepository.findModelByKey(BIAS);

    return calculateCTR(sum);
  }

  private Double calculateCTR(Double sum) {
    BigDecimal bd = new BigDecimal(sum / COEFFICIENT).setScale(10, RoundingMode.HALF_UP);
    double val2 = bd.doubleValue();
    return val2;
  }
}
