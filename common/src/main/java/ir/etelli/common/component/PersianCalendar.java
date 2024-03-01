package ir.etelli.common.component;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import ir.etelli.common.PersiancalendarModule;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;

public class PersianCalendar {

    public static String COMPONENT_ID = "ir.etelli.persiancalendar";


    public static JsonSchema SCHEMA =
        JsonSchema.parse(PersianCalendar.class.getResourceAsStream("/persiancalendar.props.json"));



    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(PersiancalendarModule.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(PersiancalendarModule.MODULE_ID)
        .setSchema(SCHEMA)
        .setName("Calendar")
        .addPaletteEntry("", "Calendar", "Multi Calendar: gregorian,persian,jalali,arabic,indian.", null, null)
        .setDefaultMetaName("Calendar")
        .setResources(PersiancalendarModule.BROWSER_RESOURCES)
        .build();

}
