//
//  ViewController.m
//  AocW4
//
//  Created by Luis Puente on 4/22/12.
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
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

//////////////////////OnClick Function for Login Button//////////////////////////////////////

-(void)onClick
{
    NSString *userLoginConfirm = [unTextF text];
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}


- (void)viewWillAppear:(BOOL)animated
{

//////////////////Username UILabel and Textfield and Login button//////////////
    
//username//
    uName = [[UILabel alloc] initWithFrame:CGRectMake(10.0f, 10.0f , 90.0f, 20.0f)];
    if(uName != nil)
    {
        uName.text =@"Username:";
    }

//textField//    
    unTextF = [[UITextField alloc] initWithFrame:CGRectMake(100.0f, 10.0f, 200.0f, 25.0f)];
    if(unTextF != nil)
    {
        unTextF.borderStyle = UITextBorderStyleRoundedRect;
    }

//Login button//
    logButt = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    if(logButt != nil)
    {
        logButt.frame = CGRectMake(200.0f, 40.0f, 100.0f, 30.0f);
        [logButt setTitle:@"Login" forState:UIControlStateNormal];
        [logButt addTarget:self action:@selector(onClick) forControlEvents:UIControlEventTouchUpInside];
    }
        
//Adding all self view addSubs at bottom. Seems a little easier to view//    
    
    [self.view addSubview:uName];
    [self.view addSubview:unTextF];
    [self.view addSubview:logButt];
    
    self.view.backgroundColor = [UIColor whiteColor];
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

@end
