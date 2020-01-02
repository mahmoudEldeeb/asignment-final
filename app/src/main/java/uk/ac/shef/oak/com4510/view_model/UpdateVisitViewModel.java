package uk.ac.shef.oak.com4510.view_model;

import androidx.lifecycle.ViewModel;

import uk.ac.shef.oak.com4510.model.models.Visit;
import uk.ac.shef.oak.com4510.model.repositry.UpdateAndDeleteRepository;

/**
 * this viewModel to update the visit
 * @author Areej
 */
public class UpdateVisitViewModel extends ViewModel {


    /**
     * it use to update the visit
     * @param visit
     */
    public void update(Visit visit){
    new UpdateAndDeleteRepository().update(visit);
}
}
