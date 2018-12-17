package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.MainPage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.ProperiesFileReader;

import java.io.IOException;

public class BirthExtractTest extends MainTest {

    private final String CHILD_ACT_RECORD = "child-act-record";
    private final String EXTRACT_TYPE = "extract-type-child";
    private final String ROLE_CHILD = "child";

    private final String CHILD_SURNAME = "child-surname";
    private final String CHILD_NAME = "child-name";
    private final String CHILD_FATHER_NAME = "child-father-name";

    private ProperiesFileReader pr;

    private ExtractPage extractPage;
    private ExtendSearch search;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPrint extractPrint;

    @Test
    public void birthExtractTest() throws IOException {
        pr = new ProperiesFileReader();
        ActRecord act = new ActRecord();
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(pr.getPropValues(CHILD_ACT_RECORD));
        extractPage.selectExtractType(pr.getPropValues(EXTRACT_TYPE));
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(pr.getPropValues(ROLE_CHILD));
        searchByPersonRibbon.enterPersonInformation(
                pr.getPropValues(CHILD_SURNAME),
                pr.getPropValues(CHILD_NAME),
                pr.getPropValues(CHILD_FATHER_NAME)
        );
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("birth", act.getActNumber()));
    }
}
