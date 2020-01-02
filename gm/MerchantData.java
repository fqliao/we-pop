package cn.webank.blockchain.contracts.web3j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray20;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
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
public class MerchantData extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b5060405160208062000f468339810180604052810190808051906020019092919050505060206040519081016040528060008152506020604051908101604052806000815250816000908051906020019061006c9291906100e8565b5080600190805190602001906100839291906100e8565b50505061009e816100a4640100000000026401000000009004565b5061018d565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061012957805160ff1916838001178555610157565b82800160010185558215610157579182015b8281111561015657825182559160200191906001019061013b565b5b5090506101649190610168565b5090565b61018a91905b8082111561018657600081600090555060010161016e565b5090565b90565b610da9806200019d6000396000f3006080604052600436106100ba576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630ce432bb146100bf5780630d23a3441461012c5780637b4832da1461019957806397de51ca146101dc578063a23fa28914610225578063a8f7ebf4146102d9578063b11b68831461032a578063b40bfca9146103ba578063d5e0ff891461044a578063d8fe5476146104c4578063df453a6d146105f3578063f4aec6fa1461063c575b600080fd5b3480156100cb57600080fd5b506100ea6004803603810190808035906020019092919050505061068d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561013857600080fd5b50610157600480360381019080803590602001909291905050506106cb565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101a557600080fd5b506101da600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610709565b005b3480156101e857600080fd5b506102076004803603810190808035906020019092919050505061074d565b60405180826000191660001916815260200191505060405180910390f35b34801561023157600080fd5b5061023a610770565b604051808060200180602001838103835285818151815260200191508051906020019060200280838360005b83811015610281578082015181840152602081019050610266565b50505050905001838103825284818151815260200191508051906020019060200280838360005b838110156102c35780820151818401526020810190506102a8565b5050505090500194505050505060405180910390f35b3480156102e557600080fd5b506103286004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061085d565b005b34801561033657600080fd5b5061033f6108f9565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561037f578082015181840152602081019050610364565b50505050905090810190601f1680156103ac5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156103c657600080fd5b506103cf610997565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561040f5780820151818401526020810190506103f4565b50505050905090810190601f16801561043c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561045657600080fd5b5061047f6004803603810190808035906020019092919080359060200190929190505050610a35565b6040518083601460200280838360005b838110156104aa57808201518184015260208101905061048f565b505050509050018281526020019250505060405180910390f35b3480156104d057600080fd5b506104d9610b2c565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b8381101561054f578082015181840152602081019050610534565b50505050905090810190601f16801561057c5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156105b557808201518184015260208101905061059a565b50505050905090810190601f1680156105e25780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b3480156105ff57600080fd5b5061061e60048036038101908080359060200190929190505050610c9a565b60405180826000191660001916815260200191505060405180910390f35b34801561064857600080fd5b5061068b6004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610cbd565b005b60048181548110151561069c57fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6006818154811015156106da57fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60058181548110151561075c57fe5b906000526020600020016000915090505481565b60608060036004818054806020026020016040519081016040528092919081815260200182805480156107c657602002820191906000526020600020905b815460001916815260200190600101908083116107ae575b505050505091508080548060200260200160405190810160405280929190818152602001828054801561084e57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610804575b50505050509050915091509091565b600382908060018154018082558091505090600182039060005260206000200160009091929091909150906000191690555060048190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b60008054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561098f5780601f106109645761010080835404028352916020019161098f565b820191906000526020600020905b81548152906001019060200180831161097257829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a2d5780601f10610a0257610100808354040283529160200191610a2d565b820191906000526020600020905b815481529060010190602001808311610a1057829003601f168201915b505050505081565b610a3d610d59565b6000806014851180610a56575083850260048054905011155b15610a6057610b24565b6000915083850290505b60048054905081108015610a82575060018401850281105b15610b235760046001826004805490500303815481101515610aa057fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168383806001019450601481101515610adf57fe5b602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508080600101915050610a6a565b5b509250929050565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bec5780601f10610bc157610100808354040283529160200191610bec565b820191906000526020600020905b815481529060010190602001808311610bcf57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c885780601f10610c5d57610100808354040283529160200191610c88565b820191906000526020600020905b815481529060010190602001808311610c6b57829003601f168201915b50505050509150925092509250909192565b600381815481101515610ca957fe5b906000526020600020016000915090505481565b600582908060018154018082558091505090600182039060005260206000200160009091929091909150906000191690555060068190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b610280604051908101604052806014906020820280388339808201915050905050905600a165627a7a72305820f6c3e72996fcf37fb77a448ae76d34fcb6089718220227349dcf35067907a4f20029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"orderList\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"compensateOrderList\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"compensateAbBizNoList\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getList\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32[]\"},{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"abBizNo\",\"type\":\"bytes32\"},{\"name\":\"order\",\"type\":\"address\"}],\"name\":\"addAbBizNo\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"pageSize\",\"type\":\"uint256\"},{\"name\":\"pageIndex\",\"type\":\"uint256\"}],\"name\":\"getOrderList\",\"outputs\":[{\"name\":\"list\",\"type\":\"address[20]\"},{\"name\":\"num\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"abBizNoList\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"abBizNo\",\"type\":\"bytes32\"},{\"name\":\"order\",\"type\":\"address\"}],\"name\":\"addCompensateAbBizNo\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"code\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"msg\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"Debug\",\"type\":\"event\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_ORDERLIST = "orderList";

    public static final String FUNC_COMPENSATEORDERLIST = "compensateOrderList";

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_COMPENSATEABBIZNOLIST = "compensateAbBizNoList";

    public static final String FUNC_GETLIST = "getList";

    public static final String FUNC_ADDABBIZNO = "addAbBizNo";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_GETORDERLIST = "getOrderList";

    public static final String FUNC_GETMETA = "getMeta";

    public static final String FUNC_ABBIZNOLIST = "abBizNoList";

    public static final String FUNC_ADDCOMPENSATEABBIZNO = "addCompensateAbBizNo";

    public static final Event DEBUG_EVENT = new Event("Debug", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected MerchantData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MerchantData(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MerchantData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MerchantData(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<String> orderList(BigInteger param0) {
        final Function function = new Function(FUNC_ORDERLIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> compensateOrderList(BigInteger param0) {
        final Function function = new Function(FUNC_COMPENSATEORDERLIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<byte[]> compensateAbBizNoList(BigInteger param0) {
        final Function function = new Function(FUNC_COMPENSATEABBIZNOLIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<Tuple2<List<byte[]>, List<String>>> getList() {
        final Function function = new Function(FUNC_GETLIST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<Tuple2<List<byte[]>, List<String>>>(
                new Callable<Tuple2<List<byte[]>, List<String>>>() {
                    @Override
                    public Tuple2<List<byte[]>, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<byte[]>, List<String>>(
                                convertToNative((List<Bytes32>) results.get(0).getValue()), 
                                convertToNative((List<Address>) results.get(1).getValue()));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addAbBizNo(byte[] abBizNo, String order) {
        final Function function = new Function(
                FUNC_ADDABBIZNO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(abBizNo), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addAbBizNo(byte[] abBizNo, String order, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDABBIZNO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(abBizNo), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addAbBizNoSeq(byte[] abBizNo, String order) {
        final Function function = new Function(
                FUNC_ADDABBIZNO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(abBizNo), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<byte[], String> getAddAbBizNoInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDABBIZNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<byte[], String>(

                (byte[]) results.get(0).getValue(), 
                (String) results.get(1).getValue()
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

    public RemoteCall<Tuple2<List<String>, BigInteger>> getOrderList(BigInteger pageSize, BigInteger pageIndex) {
        final Function function = new Function(FUNC_GETORDERLIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(pageSize), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(pageIndex)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray20<Address>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<List<String>, BigInteger>>(
                new Callable<Tuple2<List<String>, BigInteger>>() {
                    @Override
                    public Tuple2<List<String>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<String>, BigInteger>(
                                convertToNative((List<Address>) results.get(0).getValue()), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
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

    public RemoteCall<byte[]> abBizNoList(BigInteger param0) {
        final Function function = new Function(FUNC_ABBIZNOLIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> addCompensateAbBizNo(byte[] abBizNo, String order) {
        final Function function = new Function(
                FUNC_ADDCOMPENSATEABBIZNO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(abBizNo), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addCompensateAbBizNo(byte[] abBizNo, String order, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDCOMPENSATEABBIZNO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(abBizNo), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addCompensateAbBizNoSeq(byte[] abBizNo, String order) {
        final Function function = new Function(
                FUNC_ADDCOMPENSATEABBIZNO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(abBizNo), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<byte[], String> getAddCompensateAbBizNoInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDCOMPENSATEABBIZNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<byte[], String>(

                (byte[]) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public List<DebugEventResponse> getDebugEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEBUG_EVENT, transactionReceipt);
        ArrayList<DebugEventResponse> responses = new ArrayList<DebugEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DebugEventResponse typedResponse = new DebugEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.code = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.msg = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerDebugEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(DEBUG_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerDebugEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(DEBUG_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static MerchantData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerchantData(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MerchantData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerchantData(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MerchantData load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MerchantData(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MerchantData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MerchantData(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MerchantData> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(MerchantData.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MerchantData> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(MerchantData.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MerchantData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(MerchantData.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MerchantData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(MerchantData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class DebugEventResponse {
        public Log log;

        public BigInteger code;

        public String msg;

        public String addr;
    }
}
