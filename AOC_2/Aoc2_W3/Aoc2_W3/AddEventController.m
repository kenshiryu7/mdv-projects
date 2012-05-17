//
//  AddEventController.m
//  Aoc2_W3
//
//  Created by Luis Puente on 5/14/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "AddEventController.h"

@implementation AddEventController

@synthesize delegate;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

//resignFirstResonder tip from AOC 1. Works at this time.

-(IBAction)dismissKeys:(id)sender
{
    [textEvent resignFirstResponder];
}

//Action for saving information into first view. Save button

-(IBAction)onSave:(id)sender
{
    if((datePicker != nil) && (textEvent != nil))
    {
        //code for datePicker to have minimum of "today's" date//
        
        //line for min date as current date//
        datePicker.minimumDate = [NSDate date];
        NSDate *selectedDate = datePicker.date;
       
        //format date. Similar as P4 AOC1//
        NSDateFormatter *dateForm = [[NSDateFormatter alloc] init];
        if(dateForm != nil)
        {
            [dateForm setDateFormat:@"MMMM dd, yyyy  hh:mm:ss a "];
            
        //made a second date string by accident. Just leaving this in to show what I logged out in previous commit//
            // NSString *showDateString = [dateForm stringFromDate:selectedDate];
           // NSLog(@"%@",showDateString);
            
            NSString *newLabel = [[NSString alloc] initWithString:@"New Event: "];
            NSString *textInput = [[NSString alloc] initWithString:textEvent.text];
            NSString *dateInfo = [dateForm stringFromDate:selectedDate];
            NSString *eventSavedString = [[NSString alloc] initWithFormat:@"%@%@\n%@\n",newLabel, textInput, dateInfo];
            [dateForm release];
            
            [delegate didClose:eventSavedString];
        }
        
    }
    [self dismissModalViewControllerAnimated:true];
}

- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

/*
// Implement loadView to create a view hierarchy programmatically, without using a nib.
- (void)loadView
{
}
*/

/*
// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
    [super viewDidLoad];
}
*/

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

@end
