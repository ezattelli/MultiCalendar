import * as React from 'react';
import {
    Component,
    ComponentMeta,
    ComponentProps,
    PComponent, PropertyTree,
    SizeObject
} from '@inductiveautomation/perspective-client';

export const COMPONENT_TYPE = "ir.etelli.persiandatepickerrange";
import DatePicker, {DateObject} from "react-multi-date-picker"
import TimePicker from "react-multi-date-picker/plugins/time_picker";

export interface PersianDatePickerRangeProps {
    calendar: string;
    locale: string;
    date: object;
    color: string;
    background:string;
    startDay : string;
    timePicker : boolean;
    dateObject:Array<any>;
}

const week = {"Sun":0,"Mon":1,"Tue":2,"Wed":3,"Thu":4,"Fri":5,"Sat":6}


export class PersianDatePickerRange extends Component<ComponentProps<PersianDatePickerRangeProps>, any> {


    render() {

        const {props} = this.props;

            return (
                <div {...this.props.emit()} >
                    <DatePicker

                        plugins={[
                            <TimePicker disabled={!props.timePicker} position="bottom" />
                        ]}

                        className={props.color + " " + props.background}
                        calendar={props.calendar}
                        locale={props.locale}
                        weekStartDayIndex={week[props.startDay]}

                        onChange={

                            (selectedDates:DateObject[])=>{
                                let dateArray = new Array()
                                let cal: any = props.calendar
                                console.log(selectedDates)
                                console.log(selectedDates[0].convert(cal).toDate())
                                dateArray.push(selectedDates[0].convert(cal).toDate())
                                console.log(dateArray)

                                if (selectedDates.length>1){
                                    dateArray.push(selectedDates[1].convert(cal).toDate())
                                    console.log(selectedDates[1].convert(cal).toDate())
                                    console.log(dateArray)
                                }else {
                                    dateArray.push(null)
                                }
                                console.log(typeof selectedDates)
                                this.props.store.props.write("dateObject",JSON.parse(JSON.stringify(selectedDates)))
                                this.props.store.props.write("date",{"start":dateArray[0],"end":dateArray[1]})
                                console.log({"start":dateArray[0],"end":dateArray[1]})
                            }

                        }
                        range
                    />
                </div>
            );

    }
}


export class PersianDatePickerRangeMeta implements ComponentMeta {

    getComponentType(): string {
        return COMPONENT_TYPE;
    }

    getViewComponent(): PComponent {
        return PersianDatePickerRange;
    }

    getDefaultSize(): SizeObject {
        return ({
            width: 176,
            height: 25
        });
    }


    getPropsReducer(tree: PropertyTree): PersianDatePickerRangeProps {
        return {
            calendar: tree.readString("calendar", ''),
            locale: tree.readString("locale", ''),
            date: tree.readObject("date"),
            color: tree.readString("color", ''),
            startDay: tree.readString("startDay", "Sun"),
            dateObject:tree.readArray("dateObject"),
            background:tree.readString("background"),
            timePicker:tree.readBoolean("timePicker")

        };
    }


}

