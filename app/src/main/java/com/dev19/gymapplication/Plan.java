package com.dev19.gymapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {

    private Training training;
    private String day;
    private int minutes;
    public boolean isAccomplished;

    protected Plan(Parcel in) {
        training = in.readParcelable(Training.class.getClassLoader());
        day = in.readString();
        minutes = in.readInt();
        isAccomplished = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    @Override
    public String toString() {
        return "Plan{" +
                "training=" + training +
                ", day='" + day + '\'' +
                ", minutes=" + minutes +
                ", isAccomplished=" + isAccomplished +
                '}';
    }

    public Plan(Training training, String day, int minutes, boolean isAccomplished) {
        this.training = training;
        this.day = day;
        this.minutes = minutes;
        this.isAccomplished = isAccomplished;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public boolean IsAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(training, flags);
        dest.writeString(day);
        dest.writeInt(minutes);
        dest.writeByte((byte) (isAccomplished ? 1 : 0));
    }
}
