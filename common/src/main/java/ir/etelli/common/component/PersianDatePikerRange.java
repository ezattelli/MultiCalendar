package ir.etelli.common.component;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import ir.etelli.common.PersiancalendarModule;

public class PersianDatePikerRange {

    public static String COMPONENT_ID = "ir.etelli.persiandatepickerrange";


    public static JsonSchema SCHEMA =
        JsonSchema.parse(PersianDatePikerRange.class.getResourceAsStream("/persiancalendarrange.props.json"));



    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(PersiancalendarModule.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(PersiancalendarModule.MODULE_ID)
        .setSchema(SCHEMA)
        .setName("DatePickerRange")
        .addPaletteEntry("", "DatePicker Range", "Multi DatePicker Range: gregorian,persian,jalali,arabic,indian.", null, null)
        .setDefaultMetaName("DatePicker Range")
        .setResources(PersiancalendarModule.BROWSER_RESOURCES)
        .build();

}
