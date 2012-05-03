//
//  ShapeClass.h
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ShapeClass : NSObject
{
@protected
    int _numSides;
    NSString *_name;
}

-(int)GetNumSides;
-(NSString*)GetName;
-(int)GetArea;

-(id)initWithDetails:(int)numSides name:(NSString*)name;

@end
