describe('Protractor Demo App', function() {
  it('should load start page', function() {
    browser.get('http://localhost:4200/');

    expect(browser.getTitle()).toEqual('An Evening With ...');
    expect(element(by.id('inputName'))).toBeTruthy();
    expect(element(by.id('kanyeStart')).getTitle()).toEqual('KanyePic');
    expect(element(by.id('trumpStart')).getTitle()).toEqual('TrumpPic');
  });
});
