import * as React from 'react';
import {
    Component,
    ComponentMeta,
    ComponentProps,
    PComponent, PropertyTree,
    SizeObject
} from '@inductiveautomation/perspective-client';

export const COMPONENT_TYPE = "ir.etelli.persiandatepicker";
import DatePicker, {DateObject} from "react-multi-date-picker"
import TimePicker from "react-multi-date-picker/plugins/time_picker";

export interface PersianDatePickerProps {
    calendar: string;
    locale: string;
    date: object;
    color: string;
    background: string;
    startDay: string;
    timePicker: boolean;
    dateObject: object;

}

const week = {"Sun": 0, "Mon": 1, "Tue": 2, "Wed": 3, "Thu": 4, "Fri": 5, "Sat": 6}


export class PersianDatePicker extends Component<ComponentProps<PersianDatePickerProps>, any> {


    render() {

        const {props} = this.props;

        return (
            <div {...this.props.emit()} >


                <DatePicker

                    plugins={[
                        <TimePicker disabled={!props.timePicker} position="bottom"/>
                    ]}

                    className={props.color + " " + props.background}
                    calendar={props.calendar}
                    locale={props.locale}
                    weekStartDayIndex={week[props.startDay]}

                    onChange={
                        (ob: DateObject) => {
                            if (ob != null) {
                                let DO = new DateObject(ob)
                                let cal: any = props.calendar
                                this.props.store.props.write("dateObject", JSON.parse(JSON.stringify(DO.convert(cal))))
                                this.props.store.props.write("date", DO.convert(cal).toDate())
                            }

                        }
                    }
                />
            </div>
        );
    }
}


export class PersianDatePickerMeta implements ComponentMeta {

    getComponentType(): string {
        return COMPONENT_TYPE;
    }

    getViewComponent(): PComponent {
        return PersianDatePicker;
    }

    getDefaultSize(): SizeObject {
        return ({
            width: 176,
            height: 25
        });
    }

    getPropsReducer(tree: PropertyTree): PersianDatePickerProps {
        return {
            calendar: tree.readString("calendar", ''),
            locale: tree.readString("locale", ''),
            date: tree.readObject("date"),
            color: tree.readString("color", ''),
            startDay: tree.readString("startDay", "Sun"),
            dateObject: tree.readObject("dateObject"),
            background: tree.readString("background"),
            timePicker: tree.readBoolean("timePicker")
        };
    }


}

