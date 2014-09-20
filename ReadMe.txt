This plugin can be used by XPages developers writing code using the Extensibility API 
from an Eclipse IDE to debug code without having to deploy it first. See here for the documentation.



Starting in IBM Lotus Domino Server 8.5.2, XPages provides a toolkit for writing custom controls 
using OSGi plugins. Developers need to export their custom plugins from Eclipse and install them 
on the Domino Server file system before they can run and be debugged. These operations must be 
repeated every time a change is made in the code.

To improve productivity, the IBM Lotus Domino Debug Plugin removes the need for exporting and 
deploying the custom plugins by configuring the IBM Lotus Domino OSGi runtime to load the plugin 
classes directly from the Eclipse workspace.



Watch this video to see the plugin in action: http://www.youtube.com/watch?v=J84dAECKots

 

David Taieb and Dan o'Connor are the developers, Niklas Heidloff only the committer.