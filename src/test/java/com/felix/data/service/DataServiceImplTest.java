package com.felix.data.service;

import com.felix.data.Application;
import com.felix.data.domain.DataRequest;
import com.felix.data.repository.ModelRedisRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = Application.class)
class DataServiceImplTest {
  @Mock ModelRedisRepository redisRepository;

  @Autowired DataService dataService;

  @Test
  void processData() {
    Double expected = 0.0016306374;

    when(redisRepository.findModelByKey("deviceExtBrowser=Firefox")).thenReturn(-0.1131013246);
    when(redisRepository.findModelByKey("bannerExtSize=300x250")).thenReturn(-0.6282185905);
    when(redisRepository.findModelByKey("deviceExtType=tablet")).thenReturn(0.7294739471);
    when(redisRepository.findModelByKey("deviceLanguage=de")).thenReturn(-0.1935418172);
    when(redisRepository.findModelByKey("bios")).thenReturn(-6.21176449);

    Double result = dataService.processData(getDataRequest());

    Assert.notNull(result, "Not null value");
    Assertions.assertEquals(expected, result);
  }

  private DataRequest getDataRequest() {
    DataRequest dataRequest = new DataRequest();
    dataRequest.setBannerExtSize("300x250");
    dataRequest.setDeviceExtBrowser("Firefox");
    dataRequest.setDeviceExtType("tablet");
    dataRequest.setDeviceLanguage("de");
    return dataRequest;
  }
}
