package uk.ac.shef.oak.com4510.model.datebase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import uk.ac.shef.oak.com4510.model.models.Visit;
import uk.ac.shef.oak.com4510.model.models.VisitImages;
import uk.ac.shef.oak.com4510.utils.Constants;



/**
 * this class use to create and build the database
 * @author Areej
 */
@Database(entities = {Visit.class, VisitImages.class},version = 1)

public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase instance;

    public abstract VisitDao dao();


    /**
     *  to build the room database and get the reference
     * @return MyDatabase
     */
    public static MyDatabase getDatabase() {
        if (instance == null) {
            synchronized (MyDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(Constants.context.getApplicationContext(),
                            MyDatabase.class, Constants.DATABASE_NAME)
                            .build();
                }
            }
        }
        return instance;
    }

}
