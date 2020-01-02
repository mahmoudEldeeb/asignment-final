package uk.ac.shef.oak.com4510.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import uk.ac.shef.oak.com4510.model.models.Visit;
import uk.ac.shef.oak.com4510.model.models.VisitImages;
import uk.ac.shef.oak.com4510.model.repositry.InsertVisitRepository;


/**
 *
 *InsertVisitsViewModel this class is viewmodel which use to call repository to insert data into my database
 * @author  Areej
 */
public class InsertVisitsViewModel extends ViewModel {


    /**
     * here call insertVisitRepositry.insertVisitImage to insert the visit and return the id
     * @param  visit
     * it take visit object
     * @return  MutableLiveData<Long>
     * return the id of the visit
      */
    public MutableLiveData<Long>insertVisit(Visit visit)
    {
        InsertVisitRepository insertVisitRepositry=new InsertVisitRepository();
        return insertVisitRepositry.insertVisit(visit);
    }


    /**
     * here call insertVisitRepositry.insertVisitImage to insert images and return ids of visitImages
     * it take list of images object
     * it take visitImage object
     * return ids of visitImages
     * @param  images
     * @return  MutableLiveData<Long>
     *
     */

    public MutableLiveData<Long[]> insertVisitImage(List<VisitImages> images )
    {
        InsertVisitRepository insertVisitRepositry=new InsertVisitRepository();
        return insertVisitRepositry.insertVisitImage(images);
    }
}

