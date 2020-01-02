package cn.webank.blockchain.contracts.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3;
import org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray5;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tuples.generated.Tuple7;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class ClearCenterData extends Contract {
    public static String BINARY = "60806040523480156200001157600080fd5b5060405162001393380380620013938339810180604052810190808051820192919060200180518201929190505050818181600090805190602001906200005a9291906200007e565b508060019080519060200190620000739291906200007e565b50505050506200012d565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620000c157805160ff1916838001178555620000f2565b82800160010185558215620000f2579182015b82811115620000f1578251825591602001919060010190620000d4565b5b50905062000101919062000105565b5090565b6200012a91905b80821115620001265760008160009055506001016200010c565b5090565b90565b611256806200013d6000396000f3006080604052600436106100f1576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806309af2faf146100f657806309d114ff1461016757806324b8c101146101d057806346777e87146101fb57806354d6c4aa146102685780636ce5f296146102d95780637b4832da14610314578063822c3a3f1461035757806389f2a5c0146103bc57806390462fc314610401578063ace2522914610444578063b11b68831461050b578063b40bfca91461059b578063bcaa5c061461062b578063ca5e5283146106c3578063d8fe54761461070c578063fc895d4c1461083b575b600080fd5b34801561010257600080fd5b506101256004803603810190808035600019169060200190929190505050610866565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561017357600080fd5b50610192600480360381019080803590602001909291905050506108ab565b6040518082600560200280838360005b838110156101bd5780820151818401526020810190506101a2565b5050505090500191505060405180910390f35b3480156101dc57600080fd5b506101e56109d1565b6040518082815260200191505060405180910390f35b34801561020757600080fd5b50610226600480360381019080803590602001909291905050506109de565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561027457600080fd5b506102976004803603810190808035600019169060200190929190505050610a38565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156102e557600080fd5b50610312600480360381019080803560001916906020019092919080359060200190929190505050610a7d565b005b34801561032057600080fd5b50610355600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610aa1565b005b34801561036357600080fd5b506103a66004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610ae5565b6040518082815260200191505060405180910390f35b3480156103c857600080fd5b506103eb6004803603810190808035600019169060200190929190505050610bd7565b6040518082815260200191505060405180910390f35b34801561040d57600080fd5b50610442600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610bfc565b005b34801561045057600080fd5b506104f5600480360381019080803590602001909291908035906020019092919080359060200190929190803590602001909291908035906020019092919080606001906003806020026040519081016040528092919082600360200280828437820191505050505091929192908060600190600380602002604051908101604052809291908260036020028082843782019150505050509192919290505050610c65565b6040518082815260200191505060405180910390f35b34801561051757600080fd5b50610520610d22565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610560578082015181840152602081019050610545565b50505050905090810190601f16801561058d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156105a757600080fd5b506105b0610dc0565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156105f05780820151818401526020810190506105d5565b50505050905090810190601f16801561061d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561063757600080fd5b5061065660048036038101908080359060200190929190505050610e5e565b6040518083600360200280838360005b83811015610681578082015181840152602081019050610666565b5050505090500182600360200280838360005b838110156106af578082015181840152602081019050610694565b505050509050019250505060405180910390f35b3480156106cf57600080fd5b506106ee60048036038101908080359060200190929190505050610f37565b60405180826000191660001916815260200191505060405180910390f35b34801561071857600080fd5b50610721610f76565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b8381101561079757808201518184015260208101905061077c565b50505050905090810190601f1680156107c45780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156107fd5780820151818401526020810190506107e2565b50505050905090810190601f16801561082a5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561084757600080fd5b506108506110e4565b6040518082815260200191505060405180910390f35b600060056000836000191660001916815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6108b36110f1565b6000600c6000848152602001908152602001600020600001548160006005811015156108db57fe5b0181905550600c60008481526020019081526020016000206001015481600160058110151561090657fe5b0181905550600c60008481526020019081526020016000206002015481600260058110151561093157fe5b0181905550600c60008481526020019081526020016000206003015481600360058110151561095c57fe5b0181905550600c60008481526020019081526020016000206004015481600460058110151561098757fe5b0181905550806005806020026040519081016040528092919082600580156109c4576020028201915b8154815260200190600101908083116109b0575b5050505050915050919050565b6000600880549050905090565b6000600780549050821015610a2e576007828154811015156109fc57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050610a33565b600090505b919050565b600060096000836000191660001916815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b80600b60008460001916600019168152602001908152602001600020819055505050565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008060096000856000191660001916815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610b735760088390806001815401808255809150509060018203906000526020600020016000909192909190915090600019169055505b8160096000856000191660001916815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000905092915050565b6000600b60008360001916600019168152602001908152602001600020549050919050565b60078190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050565b600060e06040519081016040528089815260200188815260200187815260200186815260200185815260200184815260200183815250600c60008a8152602001908152602001600020600082015181600001556020820151816001015560408201518160020155606082015181600301556080820151816004015560a082015181600501906003610cf7929190611114565b5060c082015181600801906003610d0f929190611154565b5090505060009050979650505050505050565b60008054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610db85780601f10610d8d57610100808354040283529160200191610db8565b820191906000526020600020905b815481529060010190602001808311610d9b57829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e565780601f10610e2b57610100808354040283529160200191610e56565b820191906000526020600020905b815481529060010190602001808311610e3957829003601f168201915b505050505081565b610e6661119a565b610e6e6111bd565b610e7661119a565b610e7e6111bd565b600c6000868152602001908152602001600020600501600380602002604051908101604052809291908260038015610ecb576020028201915b815481526020019060010190808311610eb7575b50505050509150600c6000868152602001908152602001600020600801600380602002604051908101604052809291908260038015610f23576020028201915b81546000191681526020019060010190808311610f0b575b505050505090508181935093505050915091565b600080600880549050905080831015610f6b57600883815481101515610f5957fe5b90600052602060002001549150610f70565b600091505b50919050565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110365780601f1061100b57610100808354040283529160200191611036565b820191906000526020600020905b81548152906001019060200180831161101957829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110d25780601f106110a7576101008083540402835291602001916110d2565b820191906000526020600020905b8154815290600101906020018083116110b557829003601f168201915b50505050509150925092509250909192565b6000600780549050905090565b60a060405190810160405280600590602082028038833980820191505090505090565b8260038101928215611143579160200282015b82811115611142578251825591602001919060010190611127565b5b50905061115091906111e0565b5090565b8260038101928215611189579160200282015b82811115611188578251829060001916905591602001919060010190611167565b5b5090506111969190611205565b5090565b606060405190810160405280600390602082028038833980820191505090505090565b606060405190810160405280600390602082028038833980820191505090505090565b61120291905b808211156111fe5760008160009055506001016111e6565b5090565b90565b61122791905b8082111561122357600081600090555060010161120b565b5090565b905600a165627a7a72305820fe2f9c2aff250eff93f4f7c0eb34a7fc5f91132a34bda8207ac88987c9713bf00029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"abBizNo\",\"type\":\"bytes32\"}],\"name\":\"getOrderAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"currency\",\"type\":\"int256\"}],\"name\":\"getExchangeBochkRatePart1\",\"outputs\":[{\"name\":\"\",\"type\":\"int256[5]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOrgListSize\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"offset\",\"type\":\"uint256\"}],\"name\":\"getTransByIndex\",\"outputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"orgId\",\"type\":\"bytes32\"}],\"name\":\"getOrgAction\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"reqId\",\"type\":\"bytes32\"},{\"name\":\"newCheckCode\",\"type\":\"int256\"}],\"name\":\"setCheckTagReq\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"orgId\",\"type\":\"bytes32\"},{\"name\":\"orgAddr\",\"type\":\"address\"}],\"name\":\"registerOrg\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"reqId\",\"type\":\"bytes32\"}],\"name\":\"getCheckTagReq\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"orderAddr\",\"type\":\"address\"}],\"name\":\"addTrans\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"currency\",\"type\":\"int256\"},{\"name\":\"fxRate\",\"type\":\"int256\"},{\"name\":\"refundFxRate\",\"type\":\"int256\"},{\"name\":\"exTimeStamp\",\"type\":\"int256\"},{\"name\":\"currencyUnit\",\"type\":\"int256\"},{\"name\":\"exDataArr\",\"type\":\"uint256[3]\"},{\"name\":\"exDataStr\",\"type\":\"bytes32[3]\"}],\"name\":\"setExchangeRate\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"currency\",\"type\":\"int256\"}],\"name\":\"getExchangeBochkRatePart2\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[3]\"},{\"name\":\"\",\"type\":\"bytes32[3]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"getOrgByIndex\",\"outputs\":[{\"name\":\"orgId\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getTransListSize\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"abi\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GETORDERADDRESS = "getOrderAddress";

    public static final String FUNC_GETEXCHANGEBOCHKRATEPART1 = "getExchangeBochkRatePart1";

    public static final String FUNC_GETORGLISTSIZE = "getOrgListSize";

    public static final String FUNC_GETTRANSBYINDEX = "getTransByIndex";

    public static final String FUNC_GETORGACTION = "getOrgAction";

    public static final String FUNC_SETCHECKTAGREQ = "setCheckTagReq";

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_REGISTERORG = "registerOrg";

    public static final String FUNC_GETCHECKTAGREQ = "getCheckTagReq";

    public static final String FUNC_ADDTRANS = "addTrans";

    public static final String FUNC_SETEXCHANGERATE = "setExchangeRate";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_GETEXCHANGEBOCHKRATEPART2 = "getExchangeBochkRatePart2";

    public static final String FUNC_GETORGBYINDEX = "getOrgByIndex";

    public static final String FUNC_GETMETA = "getMeta";

    public static final String FUNC_GETTRANSLISTSIZE = "getTransListSize";

    @Deprecated
    protected ClearCenterData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ClearCenterData(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ClearCenterData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ClearCenterData(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<String> getOrderAddress(byte[] abBizNo) {
        final Function function = new Function(FUNC_GETORDERADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(abBizNo)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<List> getExchangeBochkRatePart1(BigInteger currency) {
        final Function function = new Function(FUNC_GETEXCHANGEBOCHKRATEPART1, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray5<Int256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<BigInteger> getOrgListSize() {
        final Function function = new Function(FUNC_GETORGLISTSIZE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getTransByIndex(BigInteger offset) {
        final Function function = new Function(FUNC_GETTRANSBYINDEX, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(offset)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getOrgAction(byte[] orgId) {
        final Function function = new Function(FUNC_GETORGACTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(orgId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setCheckTagReq(byte[] reqId, BigInteger newCheckCode) {
        final Function function = new Function(
                FUNC_SETCHECKTAGREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(reqId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(newCheckCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCheckTagReq(byte[] reqId, BigInteger newCheckCode, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCHECKTAGREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(reqId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(newCheckCode)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCheckTagReqSeq(byte[] reqId, BigInteger newCheckCode) {
        final Function function = new Function(
                FUNC_SETCHECKTAGREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(reqId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(newCheckCode)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<byte[], BigInteger> getSetCheckTagReqInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCHECKTAGREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<byte[], BigInteger>(

                (byte[]) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setMetaAddress(String meta) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMetaAddress(String meta, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMetaAddressSeq(String meta) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetMetaAddressInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> registerOrg(byte[] orgId, String orgAddr) {
        final Function function = new Function(
                FUNC_REGISTERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(orgId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(orgAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void registerOrg(byte[] orgId, String orgAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(orgId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(orgAddr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String registerOrgSeq(byte[] orgId, String orgAddr) {
        final Function function = new Function(
                FUNC_REGISTERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(orgId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(orgAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<byte[], String> getRegisterOrgInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REGISTERORG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<byte[], String>(

                (byte[]) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getRegisterOrgOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_REGISTERORG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> getCheckTagReq(byte[] reqId) {
        final Function function = new Function(FUNC_GETCHECKTAGREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(reqId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addTrans(String orderAddr) {
        final Function function = new Function(
                FUNC_ADDTRANS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(orderAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addTrans(String orderAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDTRANS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(orderAddr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addTransSeq(String orderAddr) {
        final Function function = new Function(
                FUNC_ADDTRANS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(orderAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getAddTransInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDTRANS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setExchangeRate(BigInteger currency, BigInteger fxRate, BigInteger refundFxRate, BigInteger exTimeStamp, BigInteger currencyUnit, List<BigInteger> exDataArr, List<byte[]> exDataStr) {
        final Function function = new Function(
                FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(fxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(refundFxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(exTimeStamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currencyUnit), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataStr, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setExchangeRate(BigInteger currency, BigInteger fxRate, BigInteger refundFxRate, BigInteger exTimeStamp, BigInteger currencyUnit, List<BigInteger> exDataArr, List<byte[]> exDataStr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(fxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(refundFxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(exTimeStamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currencyUnit), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataStr, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setExchangeRateSeq(BigInteger currency, BigInteger fxRate, BigInteger refundFxRate, BigInteger exTimeStamp, BigInteger currencyUnit, List<BigInteger> exDataArr, List<byte[]> exDataStr) {
        final Function function = new Function(
                FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(fxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(refundFxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(exTimeStamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currencyUnit), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataStr, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<byte[]>> getSetExchangeRateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<StaticArray3<Uint256>>() {}, new TypeReference<StaticArray3<Bytes32>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<byte[]>>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue(), 
                (BigInteger) results.get(4).getValue(), 
                convertToNative((List<Uint256>) results.get(5).getValue()), 
                convertToNative((List<Bytes32>) results.get(6).getValue())
                );
    }

    public Tuple1<BigInteger> getSetExchangeRateOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> abi() {
        final Function function = new Function(FUNC_ABI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple2<List<BigInteger>, List<byte[]>>> getExchangeBochkRatePart2(BigInteger currency) {
        final Function function = new Function(FUNC_GETEXCHANGEBOCHKRATEPART2, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray3<Uint256>>() {}, new TypeReference<StaticArray3<Bytes32>>() {}));
        return new RemoteCall<Tuple2<List<BigInteger>, List<byte[]>>>(
                new Callable<Tuple2<List<BigInteger>, List<byte[]>>>() {
                    @Override
                    public Tuple2<List<BigInteger>, List<byte[]>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<BigInteger>, List<byte[]>>(
                                convertToNative((List<Uint256>) results.get(0).getValue()), 
                                convertToNative((List<Bytes32>) results.get(1).getValue()));
                    }
                });
    }

    public RemoteCall<byte[]> getOrgByIndex(BigInteger index) {
        final Function function = new Function(FUNC_GETORGBYINDEX, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<Tuple3<String, String, String>> getMeta() {
        final Function function = new Function(FUNC_GETMETA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple3<String, String, String>>(
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getTransListSize() {
        final Function function = new Function(FUNC_GETTRANSLISTSIZE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static ClearCenterData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ClearCenterData(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ClearCenterData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ClearCenterData(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ClearCenterData load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ClearCenterData(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ClearCenterData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ClearCenterData(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ClearCenterData> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String abi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi)));
        return deployRemoteCall(ClearCenterData.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ClearCenterData> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String abi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi)));
        return deployRemoteCall(ClearCenterData.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ClearCenterData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String abi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi)));
        return deployRemoteCall(ClearCenterData.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ClearCenterData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String abi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi)));
        return deployRemoteCall(ClearCenterData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
