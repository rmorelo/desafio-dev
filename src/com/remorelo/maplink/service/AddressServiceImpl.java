package com.remorelo.maplink.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remorelo.maplink.controller.MaplinkController;
import com.remorelo.maplink.model.Address;
import com.remorelo.maplink.model.ResponseAddress;
import com.remorelo.maplink.model.ResponseRoute;
import com.remorelo.maplink.util.RequestSigner;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	
	public static final Logger logger = LoggerFactory.getLogger(MaplinkController.class);
	
	public ResponseRoute findAddress(Address pAddressStart, Address pAddressFinish) {
		
		 ResponseRoute responseRoute = null;
			try {
				String urlInicio = RequestSigner.signatureGenerateAdress(pAddressStart);
				ObjectMapper mapper = new ObjectMapper();
		        ResponseAddress addressBegin = mapper.readValue(callApi(urlInicio), ResponseAddress.class);
		        
		        String urlFim = RequestSigner.signatureGenerateAdress(pAddressFinish);
		        ResponseAddress addressFinish = mapper.readValue(callApi(urlFim), ResponseAddress.class);
		        
		        String urlRoute = RequestSigner.signatureGenerateRoute(
		        		addressBegin.getResults().get(0), 
		        		addressFinish.getResults().get(0));
		        
		        responseRoute = mapper.readValue(callApi(urlRoute), ResponseRoute.class);
		        
		        //RestTemplate restTemplate = new RestTemplate();
		        //ResponseAddress result = restTemplate.getForObject(url, ResponseAddress.class);
			} catch (InvalidKeyException e) {
				logger.error(e.getMessage());
			} catch (NoSuchAlgorithmException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			} catch (URISyntaxException e) {
				logger.error(e.getMessage());
			}
		
		return responseRoute;
	}
	
	public static String callApi(String url) throws MalformedURLException, IOException  {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
	}
}
