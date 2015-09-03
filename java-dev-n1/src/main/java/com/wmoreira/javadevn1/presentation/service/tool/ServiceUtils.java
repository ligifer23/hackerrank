package com.wmoreira.javadevn1.presentation.service.tool;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wellington.362@gmail.com
 */

public class ServiceUtils {

    public static String buildLocationFromRequest(HttpServletRequest request) {
        return new StringBuilder(request.getScheme())
                        .append("://")
                        .append(request.getServerName())
                        .append(":")
                        .append(request.getServerPort())
                        .toString();
    }
}
