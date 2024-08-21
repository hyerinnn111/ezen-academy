export const oktaConfig = {
    clientId: '0oah48nel8ohpCQdn697',
    issuer: 'https://trial-6840901.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}