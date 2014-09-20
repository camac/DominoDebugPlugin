DominoDebugPlugin
=================

This Project is a minor modification of the Domino Debug Plugin contained in the XPages SDK for Eclipse project on OpenNTF.org

The Domino Debug Plugin stopped working in Eclipse Luna.
I have made the necessary changes to get it working for Eclipse Luna, and have made them available here.

I will get a few 'beta' testers to verify that it is working okay for them as well, and if everything looks good I will submit to the Project Owners to update and create a new release on OpenNTF

Instructions to Beta Testers!
-----------------------------

Please Test this with Eclipse Luna only.

### Uninstall previous version from Luna
If you had already installed the previous version of Domino Debug Plugin into Eclipse Luna, please uninstall it from your Eclipse Luna installation before testing this new version. To do this go to:
Help -> About Eclipse -> Installation Details
Then select the Domino Debug Plugin in the Installed Software tab, and then click Uninstall at the bottem.

### Install New Version
Download this repository either by cloning or use the GitHub download as zip option.
Install the new Version to eclipse using the Update site in the:
com.ibm.domino.osgi.debug.updatesite 
folder.
Don't forget to restart eclipse! Eclipse will remind you anyway :)

### Create a new Debug Configuration
Create a new OSGi Debug Configuration just like you normally would. Apply / Debug it and you should be able to get the 'pde.launch.ini' created successfully. message.

The previous error would present itself at the point where you 'apply' or 'debug' the configuration, so this new version should not have that error at lall.

Maybe play around with deselecting / selecting plugins and re-creating the ddebug config and verify that it is having the appropriate effect when domino is restarted.
