package de.javastream.rococoa.apptest;

import ch.cyberduck.ui.cocoa.application.NSApplication;
import ch.cyberduck.ui.cocoa.foundation.NSAutoreleasePool;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        final NSAutoreleasePool pool = NSAutoreleasePool.push();
        try {
            // This method also makes a connection to the window server and completes other initialization.
            // Your program should invoke this method as one of the first statements in main();
            // The NSApplication class sets up autorelease pools (instances of the NSAutoreleasePool class)
            // during initialization and inside the event loop—specifically, within its initialization
            // (or sharedApplication) and run methods.
            final NSApplication app = NSApplication.sharedApplication();
            WindowController w = new WindowController();
            // Starts the main event loop. The loop continues until a stop: or terminate: message is
            // received. Upon each iteration through the loop, the next available event
            // from the window server is stored and then dispatched by sending it to NSApp using sendEvent:.
            // The global application object uses autorelease pools in its run method.
            app.run();
        } finally {
            pool.drain();
        }
    }
}
