//
//  ViewController.h
//  Aoc2_W3
//
//  Created by Luis Puente on 5/14/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "AddEventController.h"

@interface ViewController : UIViewController <AddEventsDelegate>

//UI Elements
{
    IBOutlet UILabel *dateTitle;
    IBOutlet UITextView *eventList;
    IBOutlet UIButton *addEvent;
}

//Action for Add Event button//

-(IBAction)onAddEvent:(id)sender;

@end
