package uk.ac.shef.oak.com4510.model.repositry;

import android.os.AsyncTask;

import uk.ac.shef.oak.com4510.model.datebase.MyDatabase;
import uk.ac.shef.oak.com4510.model.datebase.VisitDao;
import uk.ac.shef.oak.com4510.model.models.Visit;


/**
 * UpdateAndDeleteRepository this class is repository to connect with the database and get object of visitdao
 * @author  Areej
 */
public class UpdateAndDeleteRepository {


    /**
     *
     * this function return object of dao
     * @return VisitDao
     */
    public static VisitDao getDao(){
        MyDatabase db = MyDatabase.getDatabase();
        return db.dao();

    }

    /**
     * this function to delete the object of visit from the database
     * @param visit
     * @return MutableLiveData<Long>
     */
    public void delete(final Visit visit) {

        new DeleteVistAsyncTask().execute(visit);

    }
    /**
     * this function to update the object of visit in the database
     * @param visit
     * @return MutableLiveData<Long>
     */
    public void update(final Visit visit) {

        new UpdateVistAsyncTask().execute(visit);

    }




    /**
     *  this aasyncktask class to delete visit from the database using background thread
     * @author Areej
     */
    private  class DeleteVistAsyncTask extends AsyncTask<Visit, Void, Void> {

        @Override
        protected Void doInBackground(Visit... visits) {
            getDao().deleteVisit(visits[0]);
            return null;
        }
    }
    /**
     *  this aasyncktask class to update visit from the database using background thread
     * @author Areej
     */
    private  class UpdateVistAsyncTask extends AsyncTask<Visit, Void, Void> {

        @Override
        protected Void doInBackground(Visit... visits) {
            getDao().updateVisit(visits[0]);
            return null;
        }
    }
}
