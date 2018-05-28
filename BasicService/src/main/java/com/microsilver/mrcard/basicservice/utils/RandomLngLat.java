package com.microsilver.mrcard.basicservice.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomLngLat {
	public static List<String> getLatAndLng(double lat, double lng) {
		List<String> list = new ArrayList();
		for(int a=0;a<3;a++) {
			double result=(-15 + (int)(Math.random() * ((15 - (-15)) + 1)))*0.001;
			String latLng = lat+","+(lng+result);
			list.add(latLng);
		}
		for(int a=0;a<3;a++) {
			double result=(-15 + (int)(Math.random() * ((15 - (-15)) + 1)))*0.001;
			String latLng = (lat+result)+","+lng;
			list.add(latLng);
		}
		for(int a=0;a<4;a++) {
			double result=(-15 + (int)(Math.random() * ((15 - (-15)) + 1)))*0.001;
			String latLng = (lat+result)+","+(lng+result);
			list.add(latLng);
		}
		return list;

	}
}
