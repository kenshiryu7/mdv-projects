//
//  ViewController.m
//  Aoc2_W2
//
//  Created by Luis Puente on 5/6/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"

@implementation ViewController

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{

    
    onOffSwitch.on = false;
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

-(IBAction)onColorChange:(id)sender
{
    UISegmentedControl *segControl = (UISegmentedControl*)sender;
    if(segControl != nil)
    {
        int selectedIndex = segControl.selectedSegmentIndex;
    }
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
    //follow along from video//
    
     int selectedIndex = segmentControl.selectedSegmentIndex;
    
    
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

@end
