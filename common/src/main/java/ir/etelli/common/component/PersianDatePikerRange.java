package ir.etelli.common.component;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import ir.etelli.common.PersiancalendarModule;
//import ir.etelli.common.MyTimeLine;
//import org.fakester.common.RadComponents;


public class PersianDatePikerRange {

    // unique ID of the component which perfectly matches that provided in the javascript's ComponentMeta implementation
    public static String COMPONENT_ID = "ir.etelli.persiandatepickerrange";


    public static JsonSchema SCHEMA =
        JsonSchema.parse(PersianDatePikerRange.class.getResourceAsStream("/persiancalendarrange.props.json"));



    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(PersiancalendarModule.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(PersiancalendarModule.MODULE_ID)
        .setSchema(SCHEMA) //  this could alternatively be created purely in Java if desired
//            .setEvents(Arrays.asList(ON_SELECT_MODE))
        .setName("DatePickerRange")
        .addPaletteEntry("", "DatePicker Range", "Multi DatePicker Range: gregorian,persian,jalali,arabic,indian.", null, null)
        .setDefaultMetaName("DatePicker Range")
        .setResources(PersiancalendarModule.BROWSER_RESOURCES)
        .build();

}
