describe('Protractor Demo App', function() {
  var userName = 'TestUser';
  it('should load start page', function() {
    browser.get('http://localhost:4200/');

    expect(browser.getTitle()).toEqual('An Evening With ...');
    expect(element(by.id('inputName'))).toBeTruthy();
    expect(element(by.id('kanyeStart')).getTitle()).toEqual('KanyePic');
    expect(element(by.id('trumpStart')).getTitle()).toEqual('TrumpPic');
  });
  it('should start game', function () {
    element(by.id('inputName')).sendKeys(userName);
    element(by.id('trumpStart')).click();

    expect(element(by.id('quote'))).toBeTruthy();
  });
});
