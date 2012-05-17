//
//  ViewController.m
//  Aoc2_W3
//
//  Created by Luis Puente on 5/14/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "AddEventController.h"

@implementation ViewController

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Action to lead to second view

-(IBAction)onAddEvent:(id)sender
{
    AddEventController *showAddEvent = [[AddEventController alloc] initWithNibName:@"AddEvent" bundle:nil];
    if(showAddEvent != nil)
    {
        showAddEvent.delegate = self;
        [self presentModalViewController:showAddEvent animated:TRUE];
    }
}

//Action example from video. Lets see if this works. Should grab data from Save button action in second view

-(void)didClose:(NSString *)eventSavedString
{
    if([eventList.text isEqualToString:@"Please add an event"])
    {
        eventList.text = @"";
        savedUserInfo =[NSMutableString stringWithString:eventList.text];
        [savedUserInfo appendString:eventSavedString];
        eventList.text = savedUserInfo;
    }
    else
    {
        savedUserInfo =[NSMutableString stringWithString:eventList.text];
        [savedUserInfo appendString:eventSavedString];
        eventList.text = savedUserInfo;
    }
}

@end
