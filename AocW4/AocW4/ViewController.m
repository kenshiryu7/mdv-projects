//
//  ViewController.m
//  AocW4
//
//  Created by Luis Puente on 4/22/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"


//defining tags for login, date, and info button//

#define LOGIN 0
#define DATE  1
#define INFO  2

@implementation ViewController

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{

    NSDate *dateView = [NSDate date];
    
    NSDateFormatter *dateForm = [[NSDateFormatter alloc] init];
    if(dateForm != nil)
    {
        [dateForm setDateFormat:@"MM.dd.yyyy  HH:mm:ss zzzz"];
        
        
    }
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}


//////////////////////OnClick Function for Login Button//////////////////////////////////////


-(IBAction)onClick:(UIButton*)button
{
  
    if(button.tag == LOGIN)
    {
        //just started//
        NSString *userLoginConfirm = [unTextF text];
    }
    else if(button.tag == DATE)
    {
        NSDate *dateView = [NSDate date];
        
        NSDateFormatter *dateForm = [[NSDateFormatter alloc] init];
        if(dateForm != nil)
        {
            [dateForm setDateFormat:@"MMMM dd, yyyy  hh:mm:ss a zzzz"];
            NSString *showDateString = [dateForm stringFromDate:dateView];
            
//is (NSString*)needed in message with showDAteString? tried and not functioning//
        UIAlertView *dateAlert = [[UIAlertView alloc] initWithTitle:@"Date" message:showDateString delegate:nil cancelButtonTitle:@"Ok" otherButtonTitles:nil, nil];
            
            if(dateAlert != nil)
            {
                [dateAlert show];
            }
        }
    }
    else if(button.tag == INFO)
    {
        //need to work on//
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

//////////////////Username UILabel, Textfield and Login button//////////////
    
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
        
        logButt.tintColor = [UIColor lightGrayColor];
        [logButt setTitle:@"Login" forState:UIControlStateNormal];
        [logButt setTitle:@"Yeah!" forState:UIControlStateHighlighted];
        
        logButt.tag = LOGIN;
        [logButt addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        //onClick is in viewDidLoad//
    }
////////////////////////////////////////////////////////////////////////////    
////////////////////UILabel for "Please Enter Username"/////////////////////
////////////////////                                   /////////////////////
    
    openMessage = [[UILabel alloc] initWithFrame:CGRectMake(0.0f, 130.0f, 320.0f, 100.0f)];
    if(openMessage != nil)
    {
        openMessage.textAlignment = UITextAlignmentCenter;
        openMessage.textColor = [UIColor blueColor];
        openMessage.backgroundColor = [UIColor lightGrayColor];
        openMessage.text = @"Please Enter Username";
    }
  
    
///////////////////////////////////////////////////////////////////////////
//////////////////////Show Date Button/////////////////////////////////////
//////////////////////                /////////////////////////////////////
    
//Show Date//
    
    showDate = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    if(showDate != nil)
    {
        showDate.frame = CGRectMake(10.0f, 270.0f, 150.0f, 50.0f);
        
        showDate.tintColor = [UIColor lightGrayColor];
        [showDate setTitle:@"Show Date" forState:UIControlStateNormal];
        [showDate setTitle:@"Here you go!" forState:UIControlStateHighlighted];
        
        showDate.tag = DATE;
        [showDate addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
    }
    
//Date view alert//
    
    

    
///////////////////////////////////////////////////////////////////////////
//////////////////////Information button. Small "i" button./////////////////////////////////////
//////////////////////                /////////////////////////////////////
 
//info dark button//
    infoButt = [UIButton buttonWithType:UIButtonTypeInfoDark];
    if(infoButt != nil)
    {
        infoButt.frame = CGRectMake(10.0f, 360.0f, 25.0f, 25.0f);
        
        infoButt.tag = INFO;
        [infoButt addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
    }

//hidden UILabel under info button//
    appInfo = [[UILabel alloc] initWithFrame:CGRectMake(10.0f, 385.0f, 300.0f, 20.0f)];
    if(appInfo != nil)
    {
        appInfo.textColor = [UIColor redColor];
        appInfo.text =@"";
        appInfo.numberOfLines = 3;
    }
                                                    
    
    
//Adding all self view addSubs at bottom. Seems a little easier to view//    
    
    [self.view addSubview:uName];
    [self.view addSubview:unTextF];
    [self.view addSubview:logButt];
    [self.view addSubview:openMessage];
    [self.view addSubview:showDate];
    [self.view addSubview:infoButt];
    [self.view addSubview:appInfo];
    
    
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
