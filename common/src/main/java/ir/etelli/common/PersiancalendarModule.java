package ir.etelli.common;

import com.inductiveautomation.perspective.common.api.BrowserResource;

import java.util.Set;

public class PersiancalendarModule {

    public static final String MODULE_ID = "ir.etelli.persiancalendarmodl";
    public static final String URL_ALIAS = "etellicomponentalias";
    public static final String COMPONENT_CATEGORY = "Multi Calendar";
    public static final Set<BrowserResource> BROWSER_RESOURCES =
            Set.of(
                    new BrowserResource(
                            "persiancalendar-js",
                            String.format("/res/%s/PersianCalendar.js", URL_ALIAS),
                            BrowserResource.ResourceType.JS
                    ),
                    new BrowserResource("persiancalendar-css",
                            String.format("/res/%s/PersianCalendar.css", URL_ALIAS),
                            BrowserResource.ResourceType.CSS
                    )
            );
}
