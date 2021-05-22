package entity.base;

import exception.OutOfBoundsException;

/**
 * Created by: Punya Gunawardana
 * Date created: April 30, 2021	
 * Time created: 11:16 AM
 */


public interface Updatable {
	
	abstract void update() throws OutOfBoundsException;

}
