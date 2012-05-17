//
//  AddEventController.h
//  Aoc2_W3
//
//  Created by Luis Puente on 5/14/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

//following video so far//

@protocol AddEventsDelegate <NSObject>

-(void)didClose:(NSString*)eventSavedString;

@end

@interface AddEventController : UIViewController
{
    id<AddEventsDelegate>delegate;
    
    IBOutlet UIButton *saveButt;
    IBOutlet UIButton *closeKeys;
    IBOutlet UITextField *textEvent;
    IBOutlet UIDatePicker *datePicker;
}

-(IBAction)onSave:(id)sender;
-(IBAction)dismissKeys:(id)sender;

@property (strong) id<AddEventsDelegate> delegate;

@end

