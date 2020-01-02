package uk.ac.shef.oak.com4510.model.repositry;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import uk.ac.shef.oak.com4510.model.datebase.MyDatabase;
import uk.ac.shef.oak.com4510.model.datebase.VisitDao;
import uk.ac.shef.oak.com4510.model.models.Visit;
import uk.ac.shef.oak.com4510.model.models.VisitImages;

/**
 *  InsertVisitRepository this class is repository which use to connect with the database and get object of visitdao
 *  @author  Areej
 */
public class InsertVisitRepository {

    // return id of the visit
    public MutableLiveData<Long>visitInsert=new MutableLiveData<>();

    // return ids of images
    public MutableLiveData<Long[]>visitImagesInsert=new MutableLiveData<>();

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
     * this function insert object of visit into the database
     * @param visit
     * @return MutableLiveData<Long>
     */
    public MutableLiveData<Long> insertVisit(final Visit visit) {
        /// here I create object of asynctask to insert data in the background thread
        InsertVistAsyncTask insertVistAsyncTask=new InsertVistAsyncTask();
        insertVistAsyncTask.execute(visit);
        return visitInsert;

    }

    /**
     * this function insert list of images for particular visit
     * @param images
     * @return
     */
    public MutableLiveData<Long[]> insertVisitImage(final List<VisitImages> images) {

       new InsertVistImagesAsyncTask().execute(images);
        return visitImagesInsert;
    }



    /**
     *  this aasyncktask class insert visit images into the database using background thread
     * @author Areej
     */
    private  class InsertVistImagesAsyncTask extends AsyncTask<List<VisitImages>, Void, Long[]> {

        @Override
        protected Long[] doInBackground(List<VisitImages>... visitImages) {
            try {
                return getDao().insertVisitImage(visitImages[0]);
            }
            catch (Exception e){
                return null;
            }

        }
        @Override
        protected void onPostExecute(Long []lon) {
        // return ids of images
            visitImagesInsert.setValue(lon);
        }

    }
    /**
     *  this aasyncktask class insert visit into the database by using background thread
     * @author Areej
     */
    private  class InsertVistAsyncTask extends AsyncTask<Visit, Void, Long> {

        @Override
        protected Long doInBackground(Visit... models) {
            try {
                return getDao().insertVisit(models[0]);
            }
            catch (Exception e){

                Log.v("rrrr",e.getMessage());
                return Long.valueOf(0);
            }

        }
        @Override
        protected void onPostExecute(Long lon) {
            visitInsert.setValue(lon);
        }

    }

}
