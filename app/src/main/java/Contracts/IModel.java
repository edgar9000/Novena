package Contracts;

import android.support.v4.app.Fragment;

import java.util.Map;

/**
 * Created by Edgar on 20/11/2016.
 */

public interface IModel {

    public Map<Integer,Fragment> fragmentos = null;

    public Integer index =  null;

    public Fragment getNextItem();

    public Fragment getPreviousItem();

    Fragment getCurrentFragment();

    public String getCurrentFragmentName();
}
