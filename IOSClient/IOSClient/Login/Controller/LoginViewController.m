//
//  LoginViewController.m
//  IOSClient
//
//  Created by 欧阳锋 on 17/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import "LoginViewController.h"
#import "RegisterViewController.h"
#import "HttpClient.h"
#import "User.h"
#import "MainViewController.h"
#import <SVProgressHUD.h>

@interface LoginViewController ()
@property (weak, nonatomic) IBOutlet UITextField *mUsernameTextField;
@property (weak, nonatomic) IBOutlet UITextField *mPwdTextField;

@end

@implementation LoginViewController

- (void)viewDidLoad {
    self.navigationItem.title = @"登录";
}



- (IBAction)login:(id)sender {
    [SVProgressHUD show];
    HttpClient *client = [HttpClient sharedInstance];
    [client POST: @"/user/login"
          params: @{@"username" : _mUsernameTextField.text, @"pwd" : _mPwdTextField.text}
         success:^(NSString *url, id data) {
             [SVProgressHUD dismiss];
             
             if([data isKindOfClass: [NSDictionary class]]) {
                 // 例子代码，这里不做严格判断了
                 User *user = [[User alloc] initWithDictionary: data[@"data"] error: nil];
                 [self pushToMainViewController: user];
             }
         } error:^(NSString *url, NSInteger httpCode, NSInteger bizCode, NSString *error) {
             [SVProgressHUD dismiss];
             
             [self promptError: error];
         }];
}

- (void)pushToMainViewController: (User *) user {
    UIStoryboard *storyboard = [UIStoryboard storyboardWithName: @"Main" bundle: [NSBundle mainBundle]];
    MainViewController *mainViewController = [storyboard instantiateViewControllerWithIdentifier: @"mainViewController"];
    mainViewController.user = user;
    [self.navigationController presentViewController: mainViewController animated: YES completion: nil];
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
