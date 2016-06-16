package com.byteowls.jopencage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.AbstractResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageRequest;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JOpenCageGeocoder {

  private final static Logger LOGGER = LoggerFactory.getLogger(JOpenCageGeocoder.class);

  private final static String OPENCAGE_HOST = "api.opencagedata.com";
  private final static String OPENCAGE_PATH = "/geocode/v1/";

  /**
   * Not used right now because problems with httpclient
   */
  private boolean httpsEnabled = false;
  private String host = OPENCAGE_HOST;
  private String path = OPENCAGE_PATH;
  private String format = "json";
  private String apiKey;

  public JOpenCageGeocoder(String apiKey) {
    this.apiKey = apiKey;
  }

  public JOpenCageResponse forward(JOpenCageForwardRequest request) {
    return sendRequest(request);
  }

  public JOpenCageResponse reverse(JOpenCageReverseRequest request) {
    return sendRequest(request);
  }

  public URI buildUri(JOpenCageRequest jOpenCageRequest) throws URISyntaxException {
    URIBuilder uriBuilder = new URIBuilder();
    if (httpsEnabled) {
      uriBuilder.setScheme("https");
    } else {
      uriBuilder.setScheme("http");
    }
    uriBuilder.setHost(host)
    .setPath(path + format);

    for (Entry<String, String> e : jOpenCageRequest.getParameter().entrySet()) {
      if (e.getValue() != null) {
        uriBuilder.setParameter(e.getKey(), e.getValue());
      }
    }
    uriBuilder.setParameter("key", apiKey);
    return uriBuilder.build();
  }

  private JOpenCageResponse sendRequest(JOpenCageRequest jOpenCageRequest) {
    URI url = null;
    try {
      url = buildUri(jOpenCageRequest);
      LOGGER.info("JOpencage request url '{}'", url);
    } catch (URISyntaxException e1) {
      LOGGER.error("", e1);
    }

    if (url != null) {
      try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
        HttpGet getRequest = new HttpGet(url);

        ResponseHandler<JOpenCageResponse> rh = new AbstractResponseHandler<JOpenCageResponse>() {
          @Override
          public JOpenCageResponse handleEntity(HttpEntity entity) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(entity.getContent(), JOpenCageResponse.class);
          }
        };

        return httpclient.execute(getRequest, rh);
      } catch (HttpResponseException e) {
        switch (e.getStatusCode()) {
          case 400:
            LOGGER.error("Invalid request (bad request; a required parameter is missing)!");
            break;
          case 402:
            LOGGER.error("Valid request but quota exceeded (payment required)!");
            break;
          case 403:
            LOGGER.error("Invalid or missing api key!");
            break;
          case 404:
            LOGGER.error("Invalid API endpoint!");
            break;
          case 408:
            LOGGER.error("Timeout; you can try again!");
            break;
          case 410:
            LOGGER.error("Request too long!");
            break;
        }
      } catch (IOException e) {
        LOGGER.error("", e);
      }
    } else {
      LOGGER.error("No jopencage request url build!");
    }
    return null;
  }

  public boolean isHttpsEnabled() {
    return httpsEnabled;
  }

  public void setHttpsEnabled(boolean httpsEnabled) {
    this.httpsEnabled = httpsEnabled;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getApiKey() {
    return apiKey;
  }

}
