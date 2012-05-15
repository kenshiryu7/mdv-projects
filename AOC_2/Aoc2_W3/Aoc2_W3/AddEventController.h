//
//  AddEventController.h
//  Aoc2_W3
//
//  Created by Luis Puente on 5/14/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface AddEventController : UIViewController
{
    IBOutlet UIButton *saveButt;
    IBOutlet UIButton *closeKeys;
    IBOutlet UITextField *textEvent;
    IBOutlet UIDatePicker *datePicker;
}

-(IBAction)onSave:(id)sender;
-(IBAction)dismissKeys:(id)sender;

@end
