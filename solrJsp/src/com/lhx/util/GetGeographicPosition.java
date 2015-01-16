package com.lhx.util;

/**
 * Created by lhx on 14-12-16 下午3:05
 *
 * @project jspProject
 * @package com.lifeix.util
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @Description
 */
public class GetGeographicPosition {


    /**
     * 生成以中心为基准的四方形的经纬度
     * @param lat 纬度
     * @param lon 经度
     * @param radius 半径（米）
     * @return
     */
    public static double[] getAround(double lat, double lon, int radius) {
        Double latitude = lat ;
        Double longitude = lon ;

        Double degree = (24901 * 1609) / 360.0 ;
        double raidusMile = radius ;

        Double dpmLat = 1 / degree ;
        Double radiusLat = dpmLat * raidusMile ;
        //经线
        Double minLat = latitude - radiusLat ;
        Double maxLat = latitude + radiusLat ;

        Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
        Double dpmLng = 1 / mpdLng ;
        Double radiusLng = dpmLng * raidusMile ;
        //纬线
        Double minLng = longitude - radiusLng ;
        Double maxLng = longitude + radiusLng ;
        return new double[]{minLat, minLng, maxLat, maxLng};
    }

    public static double distance(double centerLon, double centerLat, double targetLon, double targetLat) {
        double jl_jd = 102834.74258026089786013677476285;// 每经度单位米;
        double jl_wd = 111712.69150641055729984301412873;// 每纬度单位米;
        double b = Math.abs((centerLat - targetLat) * jl_jd);
        double a = Math.abs((centerLon - targetLon) * jl_wd);
        return Math.sqrt((a * a + b * b));
    }
}
