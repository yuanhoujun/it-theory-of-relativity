//
//  StringUtil.m
//  IOSClient
//
//  Created by 欧阳锋 on 18/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import "StringUtil.h"

@implementation StringUtil

+ (BOOL)isBlankString:(NSString *)str {
    if(!str) return YES;
    
    if([str isKindOfClass: [NSNull class]]) return YES;
    
    
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
    
    if([str stringByTrimmingCharactersInSet: whitespace].length <= 0) {
        return YES;
    }
    
    return NO;
}

@end
