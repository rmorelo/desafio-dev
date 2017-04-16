package com.remorelo.maplink.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;  // JDK 1.8 only - older versions may need to use Apache Commons or similar.

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.remorelo.maplink.model.Address;

public class RequestSigner {
	
	private static String keyString = "z0vmywzpbCSLdJYl5mUk5m2jNGytNGt6NJu6NGU=";

	private static byte[] key;

	public static String signatureGenerateAdress(Address address) throws IOException,
  		InvalidKeyException, NoSuchAlgorithmException, URISyntaxException {

		String paramUrl = "http://api.maplink.com.br/v0/search?q=";
		
		String paramAddress = address.getStreetName()
	  		+ "," + address.getNumber()
	  		+ "," + address.getCity()
	  		+ "," + address.getState();
		
  	  	String otherParams = "&types=address,street&limit=3&applicationCode=desafiodev";
	
  	  	// Convert the string to a URL so we can parse it
  	  	URL url = new URL(paramUrl + URLEncoder.encode(paramAddress, "UTF-8") + otherParams);
	
  	  	RequestSigner signer = new RequestSigner(keyString);
  	  	String request = signer.sign(url.getPath(), url.getQuery(), "");
	
  	  	return url.getProtocol() + "://" + url.getHost() + request;
	}
	
	public static String signatureGenerateRoute(Address addressStart, Address addressStop) throws IOException,
		InvalidKeyException, NoSuchAlgorithmException, URISyntaxException {
	
		String paramUrl = "https://api.maplink.com.br/v1/route?";
		paramUrl +=	"travel.by=driving&travel.vehicle=Car&";
		paramUrl +=	"waypoint.0.latlng=" + addressStart.getLocation().getLat() + "," + addressStart.getLocation().getLng() + "&";
		paramUrl +=	"waypoint.1.latlng=" + addressStop.getLocation().getLat() + "," + addressStop.getLocation().getLng() + "&";
		paramUrl +=	"travel.mode=shortest&result=summary.distance,summary.duration,summary.tolls&applicationCode=desafiodev";

		// Convert the string to a URL so we can parse it
	  	URL url = new URL(paramUrl);

	  	RequestSigner signer = new RequestSigner(keyString);
	  	String request = signer.sign(url.getPath(), url.getQuery(), "");

	  	return url.getProtocol() + "://" + url.getHost() + request;
	}

	public RequestSigner(String keyString) throws IOException {
		// Convert the key from 'web safe' base 64 to binary
		keyString = keyString.replace('-', '+');
		keyString = keyString.replace('_', '/');
		// Base64 is JDK 1.8 only - older versions may need to use Apache Commons or similar.
		this.key = Base64.getDecoder().decode(keyString);
	}

	public String sign(String path, String query, String body) throws NoSuchAlgorithmException,
    	InvalidKeyException, UnsupportedEncodingException, URISyntaxException {

		// Retrieve the proper URL components to sign
		String resource = path + '?' + query + body;

		// Get an HMAC-SHA1 signing key from the raw key bytes
		SecretKeySpec sha1Key = new SecretKeySpec(key, "HmacSHA1");

		// Get an HMAC-SHA1 Mac instance and initialize it with the HMAC-SHA1 key
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(sha1Key);

		// compute the binary signature for the request
		byte[] sigBytes = mac.doFinal(resource.getBytes());

		// base 64 encode the binary signature
		// Base64 is JDK 1.8 only - older versions may need to use Apache Commons or similar.
		String signature = Base64.getEncoder().encodeToString(sigBytes);

		// convert the signature to 'web safe' base 64
		signature = signature.replace('+', '-');
		signature = signature.replace('/', '_');

		return resource + "&signature=" + signature;
	}
	
}