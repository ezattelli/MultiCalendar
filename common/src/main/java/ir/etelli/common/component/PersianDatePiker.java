package ir.etelli.common.component;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import ir.etelli.common.PersiancalendarModule;

public class PersianDatePiker {

    public static String COMPONENT_ID = "ir.etelli.persiandatepicker";


    public static JsonSchema SCHEMA =
            JsonSchema.parse(PersianDatePiker.class.getResourceAsStream("/persiancalendar.props.json"));


    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
            .setPaletteCategory(PersiancalendarModule.COMPONENT_CATEGORY)
            .setId(COMPONENT_ID)
            .setModuleId(PersiancalendarModule.MODULE_ID)
            .setSchema(SCHEMA)
            .setName("DatePicker")
            .addPaletteEntry("", "DatePicker", "Multi DatePicker: gregorian,persian,jalali,arabic,indian.", null, null)
            .setDefaultMetaName("DatePicker")
            .setResources(PersiancalendarModule.BROWSER_RESOURCES)
            .build();

}
