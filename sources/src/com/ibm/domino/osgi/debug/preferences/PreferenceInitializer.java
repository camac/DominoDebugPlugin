 /*
 * © Copyright IBM Corp. 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package com.ibm.domino.osgi.debug.preferences;

import java.io.File;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.ibm.domino.osgi.debug.Activator;
import com.ibm.domino.osgi.debug.utils.StringUtil;

/**
 * @author doconnor
 * 
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
    private String notesRegPath;
    private String notesRegDataPath;
    
    public PreferenceInitializer(){
        initPath();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    public void initializeDefaultPreferences() {
        
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        String path =  StringUtil.getNonNullString(notesRegPath);
        store.setDefault(PreferenceConstants.PREF_DOMINO_BIN_DIR, path);
        path = StringUtil.getNonNullString(notesRegDataPath);
        store.setDefault(PreferenceConstants.PREF_DOMINO_DATA_DIR, path);
    }


    private void initPath() {
        //try to pre populate the preferences with some actual path info
        if(notesRegPath==null){ 
            String dir = "C:\\Program Files\\IBM\\Lotus\\Domino";
            boolean progFound = false;
            boolean dataFound = false;
            if(exists(dir, false)){
                progFound = true;
                notesRegPath = dir;
            }
            final String data = "\\Data";
            dir = dir + data;
            if(exists(dir, true)){
                dataFound = true;
                notesRegDataPath = dir;
            }
            
            if(!progFound || !dataFound){
                dir = "C:\\Program(x86) Files\\IBM\\Lotus\\Domino";
                if(!progFound && exists(dir, false)){
                    progFound = true;
                    notesRegPath = dir;
                }
                dir = dir + data;
                if(!dataFound && exists(dir, true)){
                    dataFound = true;
                    notesRegDataPath = dir;
                }
            }
            if(!progFound || !dataFound){
                dir = "C:\\Domino";
                if(!progFound && exists(dir, false)){
                    progFound = true;
                    notesRegPath = dir;
                }
                dir = dir + data;
                if(!dataFound && exists(dir, true)){
                    dataFound = true;
                    notesRegDataPath = dir;
                }
            }
        }
        return;
    }
    /*
     * A path is considered valid if the resulting directory contain nserver.exe and notes.ini.
     * The data dir must contain names.nsf
     */
    private boolean exists(String path, boolean data){
        if(!data){
            File f = new File(path  + "\\nserver.exe");
            if(f.exists()){
                f = new File(path + "\\notes.ini");
                if(f.exists()){
                    return true;
                }
            }
        }else{
            File f = new File(path  + "\\names.nsf");
            if(f.exists()){
                return true;
            }
        }
        return false;
    }

}
