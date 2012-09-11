//
//  NSObject.h
//
//  Created by Philipp Haußleiter on 11.09.12.
//

#import <Cocoa/Cocoa.h>

@interface MyObject : NSView /* Specify a superclass (eg: NSObject or NSView) */ {
    IBOutlet id mainWindow;
    IBOutlet id textField;
}
- (IBAction)buttonClicked:(id)sender;
@end
