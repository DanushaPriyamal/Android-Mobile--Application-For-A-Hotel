package com.example.mobileapplicationdevelopmentassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class luxeVistaDB extends SQLiteOpenHelper {
    public static  final int VERSION=5;

    public static String DB_Name="LuxeVista_Database";

    public static String SU_Table_Name="Sign_Up_Table";

    public static String Room_Table="Room_Table";

    public static String Room_Booking_Table="Room_Booking_Table";

    public static String Service_Table="Service_Table";

    public static String Service_Reservation_Table="Service_Reservation_Table";

    public static String Offers_And_Attractions_Table="Offers_And_Attractions_Table";

    public static String Notification_Table="Notification_Table";

    public static String SU_ID="Sign_Up_ID";

    public static String Room_ID="Room_ID";

    public static String Booking_ID="Booking_ID";

    public static String Service_ID="Service_ID";

    public static String Service_Reservation_ID="Service_Reservation_ID";

    public static String Offers_And_Attractions_ID="Offers_And_Attractions_ID";

    public static String Notification_ID="Notification_ID";

    public static String SU_Full_Name="Sign_Up_Full_Name";

    public static String SU_Email="Sign_Up_Email";

    public static String SU_Mobile_Number="Sign_Up_Mobile_Number";

    public static String SU_Password="Sign_Up_Password";

    public static  String SU_Status="Sign_Up_Status";

    public static String Travel_Dates="Travel_Dates";

    public static String Preferences="Preferences";

    public static String Room_Type="Room_Type";

    public static String Price="Price";

    public static String Room_Description="Room_Description";

    public static String Room_Image="Room_Image";

    public static String Room_Availability= "Availability";

    public static String Booking_Full_Name="Booking_Full_Name";

    public static String Booking_Email="Booking_Email";

    public static String Booking_Room_Type="Booking_Room_Type";

    public static String Service_Type="Service_Type";

    public static String Service_Price="Service_Price";

    public static String Service_Description="Service_Description";

    public static String Service_Image="Service_Image";

    public static String Service_Reservation_Full_Name="Full_Name";

    public static String Service_Reservation_Email="Email";

    public static String Service_Reservation_Type="Service_Type";

    public static String Service_Reservation_Date="Reservation_Date";

    public static String Service_Reservation_Time="Reservation_Time";

    public static String Offers_And_Attractions_Topic="Topic";

    public static String Offers_And_Attractions_Price="Offers_And_Attractions_Price";

    public static String Offers_And_Attractions_Description="Description";

    public static String Offers_And_Attractions_Image="Image";

    public static String Notification_Topic="Notification_Topic";

    public static String Notification_Description="Notification_Description";

    public luxeVistaDB(@Nullable Context context) {
        super(context, DB_Name, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Table_Create_Sign_Up_Table="CREATE TABLE " + SU_Table_Name + " " +
                "("
                + SU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SU_Full_Name + " TEXT,"
                + SU_Email + " TEXT,"
                + SU_Mobile_Number + " TEXT,"
                + SU_Password + " TEXT,"
                + Travel_Dates + " TEXT,"
                + Preferences + " TEXT,"
                + SU_Status + " INTEGER"
                + ");";

        sqLiteDatabase.execSQL(Table_Create_Sign_Up_Table);

        String Table_Create_Room_Table="CREATE TABLE " + Room_Table + " " +
                "("
                + Room_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Room_Type + " TEXT,"
                + Price + " TEXT,"
                + Room_Description + " TEXT,"
                + Room_Image + " BLOB,"
                + Room_Availability + " TEXT"
                + ");";

        sqLiteDatabase.execSQL(Table_Create_Room_Table);

        String Table_Create_Room_Booking="CREATE TABLE " + Room_Booking_Table + " " +
                "("
                + Booking_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Booking_Full_Name + " TEXT,"
                + Booking_Email + " TEXT,"
                + Booking_Room_Type + " TEXT"
                + ");";

        sqLiteDatabase.execSQL(Table_Create_Room_Booking);

        String Table_Create_Service_Table="CREATE TABLE " + Service_Table + " " +
                "("
                + Service_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Service_Type + " TEXT,"
                + Service_Price + " TEXT,"
                + Service_Description + " TEXT,"
                + Service_Image + " BLOB"
                + ");";

        sqLiteDatabase.execSQL(Table_Create_Service_Table);

        String Table_Create_Service_Reservation_Table="CREATE TABLE " + Service_Reservation_Table + " " +
                "("
                + Service_Reservation_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Service_Reservation_Full_Name + " TEXT,"
                + Service_Reservation_Email + " TEXT,"
                + Service_Reservation_Type + " TEXT,"
                + Service_Reservation_Date + " TEXT,"
                + Service_Reservation_Time + " TEXT"
                + ");";

        sqLiteDatabase.execSQL(Table_Create_Service_Reservation_Table);

        String Table_Create_Offers_And_Attractions_Table="CREATE TABLE " + Offers_And_Attractions_Table + " " +
                "("
                + Offers_And_Attractions_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Offers_And_Attractions_Topic + " TEXT,"
                + Offers_And_Attractions_Price + " TEXT,"
                + Offers_And_Attractions_Description + " TEXT,"
                + Offers_And_Attractions_Image + " BLOB"
                + ");";

        sqLiteDatabase.execSQL(Table_Create_Offers_And_Attractions_Table);

        String Table_Create_Notification_Table="CREATE TABLE " + Notification_Table + " " +
                "("
                + Notification_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Notification_Topic + " TEXT,"
                + Notification_Description + " TEXT"
                + ");";

        sqLiteDatabase.execSQL(Table_Create_Notification_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String Drop_Sign_Up_Table_Query="DROP TABLE IF EXISTS " + SU_Table_Name + ";";
        sqLiteDatabase.execSQL(Drop_Sign_Up_Table_Query);

        String Drop_Room_Table_Query="DROP TABLE IF EXISTS " + Room_Table + ";";
        sqLiteDatabase.execSQL(Drop_Room_Table_Query);

        String Drop_Room_Booking_Table_Query="DROP TABLE IF EXISTS " + Room_Booking_Table + ";";
        sqLiteDatabase.execSQL(Drop_Room_Booking_Table_Query);

        String Drop_Service_Table_Query="DROP TABLE IF EXISTS " + Service_Table + ";";
        sqLiteDatabase.execSQL(Drop_Service_Table_Query);

        String Drop_Service_Reservation_Table_Query="DROP TABLE IF EXISTS " + Service_Reservation_Table + ";";
        sqLiteDatabase.execSQL(Drop_Service_Reservation_Table_Query);

        String Drop_Offers_And_Nearby_Attractions_Table_Query="DROP TABLE IF EXISTS " + Offers_And_Attractions_Table + ";";
        sqLiteDatabase.execSQL(Drop_Offers_And_Nearby_Attractions_Table_Query);

        String Drop_Notification_Table_Query="DROP TABLE IF EXISTS " + Notification_Table + ";";
        sqLiteDatabase.execSQL(Drop_Notification_Table_Query);

        onCreate(sqLiteDatabase);
    }

    public void addSignUpData(signUp sign_up){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(SU_Full_Name, sign_up.getSu_Full_Name());
        contentValues.put(SU_Email, sign_up.getSu_Email());
        contentValues.put(SU_Mobile_Number, sign_up.getSu_Mobile_Number());
        contentValues.put(SU_Password, sign_up.getSu_Password());
        contentValues.put(SU_Status, sign_up.getSu_Status());

        db.insert(SU_Table_Name, null, contentValues);
        db.close();
    }

    public void addRoomBookingData(roomBookingTableJavaClass rbtjc){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Booking_Full_Name, rbtjc.getBookingFullName());
        contentValues.put(Booking_Email, rbtjc.getBookingEmail());
        contentValues.put(Booking_Room_Type, rbtjc.getBookingRoomType());

        db.insert(Room_Booking_Table, null, contentValues);
        db.close();
    }

    public void addServiceReservationData(serviceReservationFormJavaClass srfjc){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Service_Reservation_Full_Name, srfjc.getReservationFullName());
        contentValues.put(Service_Reservation_Email, srfjc.getReservationEmail());
        contentValues.put(Service_Reservation_Type, srfjc.getReservationType());
        contentValues.put(Service_Reservation_Date, srfjc.getReservationDate());
        contentValues.put(Service_Reservation_Time, srfjc.getReservationTime());

        db.insert(Service_Reservation_Table, null, contentValues);
        db.close();
    }

    public void insertRoom(String type, String price, String description, byte[] image, String availability) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Room_Type, type);
        values.put(Price, price);
        values.put(Room_Description, description);
        values.put(Room_Image, image);
        values.put(Room_Availability, availability);
        db.insert(Room_Table, null, values);
        db.close();
    }

    public void insertServices(String type, String price, String description, byte[] image){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Service_Type, type);
        values.put(Service_Price, price);
        values.put(Service_Description, description);
        values.put(Service_Image, image);
        db.insert(Service_Table, null, values);
        db.close();
    }

    public void insertOffersAndNearbyAttractions(String topic, String price, String description, byte[] image){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Offers_And_Attractions_Topic, topic);
        values.put(Offers_And_Attractions_Price, price);
        values.put(Offers_And_Attractions_Description, description);
        values.put(Offers_And_Attractions_Image, image);
        db.insert(Offers_And_Attractions_Table,null, values);
        db.close();
    }

    public void insertNotifications(String topic, String description){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Notification_Topic, topic);
        values.put(Notification_Description, description);
        db.insert(Notification_Table, null, values);
        db.close();
    }

    public boolean validateSignInData(String email, String password){
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM " + SU_Table_Name + " WHERE " + SU_Email + "=? AND " + SU_Password + "=?";
        Cursor cursor= db.rawQuery(query, new String[] {email, password});

        boolean isValid=cursor.getCount()>0;
        cursor.close();
        db.close();

        return isValid;
    }

    public boolean validateUserData(String fullName, String email){
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM " + SU_Table_Name + " WHERE " + SU_Full_Name + "=? AND " + SU_Email + "=?";
        Cursor cursor= db.rawQuery(query, new String[] {fullName, email});

        boolean isValid=cursor.getCount()>0;
        cursor.close();
        db.close();

        return isValid;
    }

    public boolean validateRoomBookingEmail(String email){
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM " + Room_Booking_Table + " WHERE " + Booking_Email + "=?";
        Cursor cursor=db.rawQuery(query, new String[]{email});

        boolean isValid=cursor.getCount()>0;
        cursor.close();
        db.close();

        return isValid;
    }

    public boolean validateReservationEmail(String email){
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM " + Service_Reservation_Table + " WHERE " + Service_Reservation_Email + "=?";
        Cursor cursor= db.rawQuery(query, new String[]{email});

        boolean isValid=cursor.getCount()>0;
        cursor.close();
        db.close();

        return isValid;
    }

    public boolean updateTravelDatesAndPreferences(String name, String email, String travelDates, String preferences) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Travel_Dates, travelDates);
        values.put(Preferences, preferences);

        int rowsAffected = db.update(SU_Table_Name, values, SU_Full_Name + "=? AND " + SU_Email + "=?", new String[]{name, email});
        return rowsAffected > 0;
    }

    public boolean updateRoomAvailability(String roomType, String roomAvailability) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Room_Availability, roomAvailability);

        int rowsAffected = db.update(Room_Table, values, Room_Type + "=?", new String[]{roomType});
        return rowsAffected > 0;
    }

    public Cursor getSortedRooms(String sortBy) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + Room_Table + " ORDER BY " + sortBy + ";", null);
    }

    public Cursor getSortedServices(String sortBy) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + Service_Reservation_Table + " ORDER BY " + sortBy + ";", null);
    }

    public Cursor getBookingsByEmail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + Room_Booking_Table + " WHERE " + Booking_Email + " =?", new String[]{email});
    }

    public Cursor getReservationsByEmail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + Service_Reservation_Table + " WHERE " + Service_Reservation_Email + " =?", new String[]{email});
    }

    public Cursor getServiceDetails(){
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + Service_Table + ";", null);
    }

    public Cursor getOffersAndNearbyAttractionsDetails(){
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + Offers_And_Attractions_Table + ";", null);
    }

    public Cursor getNotificationDetails(){
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + Notification_Table + ";", null);
    }

    public boolean deleteBooking(int ID){
        SQLiteDatabase db=this.getWritableDatabase();
        int rawAffected=db.delete(Room_Booking_Table, Booking_ID + " =?", new String[]{String.valueOf(ID)});
        return rawAffected>0;
    }

    public boolean deleteReservation(int ID){
        SQLiteDatabase db=this.getWritableDatabase();
        int rawAffected=db.delete(Service_Reservation_Table, Service_Reservation_ID + " =?", new String[]{String.valueOf(ID)});
        return rawAffected>0;
    }
}
