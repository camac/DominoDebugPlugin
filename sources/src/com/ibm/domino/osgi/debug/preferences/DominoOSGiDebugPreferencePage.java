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

import static com.ibm.domino.osgi.debug.preferences.PreferenceConstants.PREF_DOMINO_BIN_DIR;
import static com.ibm.domino.osgi.debug.preferences.PreferenceConstants.PREF_DOMINO_DATA_DIR;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.ibm.domino.osgi.debug.Activator;

/**
 * @author dtaieb
 * @author doconnor
 *
 * This class represents the main preference page for Domino OSGi Debug tooling
 */
public class DominoOSGiDebugPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public DominoOSGiDebugPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Domino OSGi Debug Tool Preference Page");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(PREF_DOMINO_BIN_DIR, "&Domino Bin Directory:", getFieldEditorParent()));
		addField(new DirectoryFieldEditor(PREF_DOMINO_DATA_DIR, "&Domino Data Directory:", getFieldEditorParent()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}