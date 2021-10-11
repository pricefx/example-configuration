def contractId = out.PromotionDiscountContract?.selectedContractId
if (contractId) {
    return api.getBaseURL() + "/app/#/contracts/detail/${contractId}/contractDetail"
}


