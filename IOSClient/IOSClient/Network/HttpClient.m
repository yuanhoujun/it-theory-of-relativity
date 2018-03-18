//
//  HttpClient.m
//  IOSClient
//
//  Created by 欧阳锋 on 17/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import "HttpClient.h"
#import <AFNetworking.h>
#import "Response.h"

@implementation HttpClient

static const NSString *BASE_URL = @"http://192.168.31.146:8080";

- (instancetype)init {
    self = [super init];
    if (self) {
        self.baseUrl = BASE_URL;
    }
    return self;
}

+ (HttpClient *)initWithBaseUrl:(NSString *)baseUrl {
    HttpClient *client = [[HttpClient alloc] init];
    client.baseUrl = baseUrl;
    
    return client;
}

+ (HttpClient *)sharedInstance {
    static HttpClient *client = nil;
    static dispatch_once_t once;
    dispatch_once(&once, ^{
        client = [[self alloc] init];
    });
    return client;
}

- (void)POST:(NSString *)url params:(NSDictionary *)params success:(void (^)(NSString *, id))success error:(void (^)(NSString *, NSInteger, NSInteger, NSString *))error {
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    manager.responseSerializer = [AFJSONResponseSerializer serializer];
    [[AFHTTPSessionManager manager] POST: [_baseUrl stringByAppendingString:url]
                              parameters: params
                                progress: nil
                                 success: ^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
                                     if(nil != success) {
                                         if(nil != responseObject) {
                                             if([responseObject isKindOfClass: [NSDictionary class]]) {
                                                 NSNumber *numberCode = ((NSDictionary *)responseObject)[@"code"];
                                                 
                                                 NSInteger code = numberCode.longValue;
                                                 
                                                 if(SUCCESS == code) {
                                                     success(url, responseObject);
                                                 } else {
                                                     if(nil != error) {
                                                         NSString *msg = ((NSDictionary *)responseObject)[@"msg"];
                                                         error(url, SC_OK, code, msg);
                                                     }
                                                 }
                                             }
                                         }
                                     }
                                 }
                                 failure: ^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull nsError) {
                                     if(nil != nsError) {
                                         error(url, nsError.code, nil, nsError.description);
                                     }
                                 }];
    
}

@end
