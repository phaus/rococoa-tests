/**
 * WindowController
 * 01.09.2012
 * @author Philipp Haussleiter
 *
 */
package de.javastream.rococoa.apptest;

import ch.cyberduck.ui.cocoa.application.NSTextField;
import ch.cyberduck.ui.cocoa.application.NSWindow;
import ch.cyberduck.ui.cocoa.foundation.NSBundle;
import ch.cyberduck.ui.cocoa.foundation.NSObject;
import org.rococoa.ID;
import org.rococoa.Rococoa;

public class WindowController {

    public WindowController() {
        String bundleName = "HelloWorld";
        // Load the NIB file and pass it our Rococoa proxy as the file owner.
        if (!NSBundle.loadNibNamed(bundleName, this.id())) {
            System.err.println("Couldn't load " + bundleName + ".nib");
            return;
        }
    }
    // Injected outlet from NIB
    private NSWindow mainWindow;

    private NSTextField textField;

    // Called when loading NIB using NSBundle. NIB has a mainWindow outlet defined.
    public void setMainWindow(NSWindow mainWindow) {
        System.out.println("Outlet set to: " + mainWindow.title());
    }

    public void setTextField(NSTextField textField){
        this.textField = textField;
    }
    
    // NSButton in NIB has an action to the file owner named buttonClicked:
    public void buttonClicked(ID sender) {
        textField.setStringValue("Hello World from: " + sender);
    }
    /**
     * You need to keep a reference to the returned value for as long as it is
     * active. When it is GCd, it will release the Objective-C proxy.
     */
    private NSObject proxy;
    private ID id;

    public NSObject proxy() {
        return this.proxy(NSObject.class);
    }

    public NSObject proxy(Class<? extends NSObject> type) {
        if (null == proxy) {
            proxy = Rococoa.proxy(this, type);
        }
        return proxy;
    }

    public org.rococoa.ID id() {
        return this.id(NSObject.class);
    }

    public org.rococoa.ID id(Class<? extends NSObject> type) {
        if (null == id) {
            id = this.proxy(type).id();
        }
        return id;
    }
}
