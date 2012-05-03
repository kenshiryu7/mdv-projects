//
//  ShapeClass.m
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ShapeClass.h"

@implementation ShapeClass

-(id)initWithDetails:(int)numSides name:(NSString*)name;
{
    self = [super init];
    if(self != nil)
    {
        _numSides = numSides;
        _name = name;
        
    }
    
    return self;
}


//possibly used for other classes?//
/*-(id)init
{
    self = [super init];
    if(self != nil)
    {
        //any init for this object
    }
    
    return self;
}
*/ 
 
-(int)GetNumSides
{
    return _numSides;
}

-(NSString*)GetName
{
    return _name;
}

-(int)GetArea
{
    return 0;
}

@end
